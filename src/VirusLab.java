public class VirusLab {
    public static void main(String[] args) {
        int numViruses = Integer.parseInt(args[0]);
        if (numViruses > 0) {
            Virus[] virii = new Virus[numViruses];
            for (int i = 0; i < numViruses; i++) {
                virii[i] = new Virus();
            }
            System.out.println("There are " + Virus.getVirusCount()
            + " viruses.");
        }
    }
}