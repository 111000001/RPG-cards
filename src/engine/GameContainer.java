package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JFrame;

import engine.gfx.Window;
import game.Game;

public class GameContainer extends Window {

    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private Thread tickThread;
    private Thread renderThread;
    private boolean isRunning = true;
    private static final int PORTA = 7000;

    public BufferedImage image;
    private Game game;
    public Input input;

    private final Object lock = new Object();
    private final int FPS = 60;
    
    public GameContainer() {
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        initFrame(frame);
        image = new BufferedImage(WIDTH , HEIGHT , BufferedImage.TYPE_INT_RGB);
        game = new Game();
    }

    public synchronized void start() {
        tickThread = new Thread(this::tickLoop);
        renderThread = new Thread(this::renderLoop);

        input = new Input(this);
        isRunning = true;

        tickThread.start();
        renderThread.start();
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            tickThread.join();
            renderThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tickLoop() {
        long lastTime = System.nanoTime();
        double amountOfTicks = FPS;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                delta--;
            }
        }
    }

    private void renderLoop() {
        long lastTime = System.nanoTime();
        double amountOfFrames = FPS;
        double ns = 1000000000 / amountOfFrames;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();

        requestFocus();
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                render();
                frames++;
                delta--;
            }

            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer += 1000;
            }
        }
    }

    public void tick() {
    	
        if (estaExecutando()) {
            System.exit(0);
        }
        
        synchronized (lock) {
            game.tick();
            input.tick();
        }
    }

    public void render() {
    	
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        // Desenhar na BufferedImage primeiro
        Graphics g = image.getGraphics();

        // Limpar a tela com uma cor de fundo, como preto
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Renderizar o jogo
        game.render(g);

        // Descartar o Graphics da imagem
        g.dispose();

        // Desenhar a imagem no BufferStrategy
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
        g.dispose();

        bs.show();
    }


    private static boolean estaExecutando() {
        try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
            // A porta está disponível, a aplicação não está em execução
            return false;
        } catch (IOException e) {
            // A porta já está em uso, a aplicação está em execução
            return true;
        }
    }
}
