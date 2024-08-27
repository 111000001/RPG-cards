package game.gfx;

import java.util.Comparator;

public interface Deepable {
	
    int getDepth();

    public static Comparator<Deepable> nodeSorter = new Comparator<Deepable>() {
        
        @Override
        public int compare(Deepable n0, Deepable n1) {
            if (n1.getDepth() < n0.getDepth())
                return +1;
            if (n1.getDepth() > n0.getDepth())
                return -1;
            return 0;
        }
        
    };
}
