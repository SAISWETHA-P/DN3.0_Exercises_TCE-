public class BuilderPattern {

    // Product Class
    public static class Computer {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String powerSupply;
        private String motherboard;

        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.GPU = builder.GPU;
            this.powerSupply = builder.powerSupply;
            this.motherboard = builder.motherboard;
        }

        // Static nested Builder class
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String GPU;
            private String powerSupply;
            private String motherboard;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGPU(String GPU) {
                this.GPU = GPU;
                return this;
            }

            public Builder setPowerSupply(String powerSupply) {
                this.powerSupply = powerSupply;
                return this;
            }

            public Builder setMotherboard(String motherboard) {
                this.motherboard = motherboard;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU + ", powerSupply="
                    + powerSupply + ", motherboard=" + motherboard + "]";
        }
    }

    // Test the Builder Implementation
    public static void main(String[] args) {
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setPowerSupply("750W")
                .setMotherboard("ASUS ROG")
                .build();

        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}
