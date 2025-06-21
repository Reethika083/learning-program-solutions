public class Main {
    public static void main(String[] args) {
        // Basic computer
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB").build();

        // Gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .build();

        System.out.println("BASIC COMPUTER:");
        basicComputer.showSpecs();

        System.out.println("\nGAMING COMPUTER:");
        gamingComputer.showSpecs();
    }
}
