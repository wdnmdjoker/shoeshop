import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Shoe> shoes = null;

    public Shop() {
        shoes = new ArrayList<>();
    }

    public boolean add(Shoe shoe) {
        return shoes.add(shoe);
    }

    public String list() {
        if (shoes.isEmpty()) {
            return "No shoes in the shop";
        } else {
            String listOfShows = "";
            for (int i = 0; i < shoes.size(); i++) {
                listOfShows += i + ": " + shoes.get(i) + "\n";
            }
            return listOfShows;
        }
    }

    public Shoe find(String brand) {
        Shoe find =  null;
        for (int i = 0; i < shoes.size(); i++) {
            if (shoes.get(i).getBrand().equals(brand)) {
                find = shoes.get(i);
                break;
            }
        }
        return find;
    }

    public Shoe update(Shoe oldShoe, Shoe newShoe) {
        return shoes.set(shoes.indexOf(oldShoe), newShoe);
    }

    public boolean delete(Shoe shoe) {
        return shoes.remove(shoe);
    }
}
