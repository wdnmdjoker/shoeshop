import java.util.List;
import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Shop shop = new Shop();

    public static void main(String[] args) {
        System.out.println("Shoe Project V 1.0");

        Driver driver = new Driver();

        driver.runMenu();

    }

    ///////////////////////////////////////////////////////
    private int mainMenu() {
        System.out.print("""
                Shoe Shop Menu
                ---------
                  (1) Add a shoe
                  (2) List a shoe
                  (3) Update a shoe details
                  (4) Delete a shoe from the system
                  (0) Exit
                ==>> """);
        int option = input.nextInt();
        return option;
    }

    ///////////////////////////////////////////////////////
    private void runMenu() {
        int option = mainMenu();

        while (option != 0) {
            switch (option) {
                case 1 -> addAShoe();
                case 2 -> printAllShoes();
                case 3 -> updateShoe();
                case 4 -> deleteShoe();
                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress enter key to continue...");
            input.nextLine(); //second read is required - bug in Scanner class; a String read is ignored straight after reading an int.

            //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting...bye bye");
        System.exit(0);
    }

    private void updateShoe() {
        input.nextLine();

        System.out.print("Please Enter a Shoe Brand to Find : ");
        String brand = input.nextLine();
        //find the shoes in the shop with this brand and display them
        List<Shoe> shoes = shop.find(brand);
        if (shoes == null || shoes.isEmpty()) {
            System.out.println("There are no Things with the brand [" + brand + "] in the Shop.");
        } else {
            //display the shoes with index numbers
            System.out.println("Shoes with the brand [" + brand + "] are:");
            for (int i = 0; i < shoes.size(); i++) {
                System.out.println(i + ": " + shoes.get(i));
            }
            //choose the shoe to update
            System.out.println("Enter the index of the Shoe to update : ");
            int index = input.nextInt();
            input.nextLine();
            if (index < 0 || index >= shoes.size()) {
                System.out.println("Invalid index entered");
                return;
            }
            Shoe shoe = shoes.get(index);
            System.out.println("The Shoe you want to update is: " + shoe.toString());
            System.out.print("Enter the New Brand:  ");
            String b = input.nextLine();
            System.out.print("Enter the New Type:  ");
            String type = input.nextLine();
            System.out.print("Enter the New Size:  ");
            float size = Float.parseFloat(input.nextLine());
            System.out.print("Enter the New Price:  ");
            float price = Float.parseFloat(input.nextLine());
            System.out.print("Enter the New Color:  ");
            String color = input.nextLine();

            Shoe temp = new Shoe(b, type, size, price, color);
            Shoe isAdded = shop.update(shoe, temp);
            if (isAdded != null) {
                System.out.println("Shoe Updated Successfully");
            } else {
                System.out.println("Shoe Updated Fail");
            }
        }
    }

    private void deleteShoe() {
        input.nextLine();

        System.out.print("Please Enter a Shoe Brand to Find : ");
        String brand = input.nextLine();
        List<Shoe> shoes = shop.find(brand);
        if (shoes == null) {
            System.out.println("There are no Things with the brand [" + brand + "] in the Shop.");
        } else {

            System.out.println("Shoes with the brand [" + brand + "] are:");
            for (int i = 0; i < shoes.size(); i++) {
                System.out.println(i + ": " + shoes.get(i));
            }
            System.out.print("Enter the index of the Shoe to delete : ");
            int index = input.nextInt();
            if (index < 0 || index >= shoes.size()) {
                System.out.println("Invalid index entered");
                return;
            }
            Shoe shoe = shoes.get(index);
            System.out.println(shoe.toString());
            System.out.print("Sure you want to delete(y/n): ");
            String yn = input.nextLine();
            if (yn.equalsIgnoreCase("y")) {
                boolean isDel = shop.delete(shoe);
                if (isDel) {
                    System.out.println("Shoe Deleted Successfully");
                } else {
                    System.out.println("Shoe Deleted Fail");
                }
            }
        }
    }


    private void addAShoe() {
        input.nextLine();  //dummy read of String to clear the buffer - bug in Scanner class.

        System.out.print("Enter the Brand:  ");
        String brand = input.nextLine();
        System.out.print("Enter the Type:  ");
        String type = input.nextLine();
        System.out.print("Enter the Size:  ");
        float size = Float.parseFloat(input.nextLine());
        System.out.print("Enter the Price:  ");
        float price = Float.parseFloat(input.nextLine());
        System.out.print("Enter the Color:  ");
        String color = input.nextLine();

        Shoe temp = new Shoe(brand, type, size, price, color);

        boolean isAdded = shop.add(temp);
        if (isAdded) {
            System.out.println("Shoe Added Successfully");
        } else {
            System.out.println("Shoe Added Fail");
        }
    }

    private void printAllShoes() {
        System.out.println("List of Shows are:");
        System.out.println(shop.list());
    }


}
