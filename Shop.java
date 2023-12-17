import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Shoe> find(String brand) {
        return shoes.stream().filter((shoe) -> (shoe.getBrand().contains(brand)))
                .collect(Collectors.toList());
    }

    public Shoe update(Shoe oldShoe, Shoe newShoe) {
        return shoes.set(shoes.indexOf(oldShoe), newShoe);
    }

    public boolean delete(Shoe shoe) {
        return shoes.remove(shoe);
    }
}
