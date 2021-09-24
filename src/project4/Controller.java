package project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class will be used to control the project4.fxml file.
 * The controller is in charge of making all of the GUI elements to be made, appear, and make it so we can interact with them.
 * The controller will also handle accessing our other controller and FXML.
 * We will also handle a majority of the calculations, object handling, and outputting through this controller.
 * @Authors Pujan Pate and Martin Colucci.
 */
public class Controller
{
    static Order order = new Order();
    double priceDouble = 0;
    int orderNum = -1;

    Sandwich sandwich;
    ObservableList<String> inputStrings = FXCollections.observableArrayList(
            "American Cheese","Basil Pesto", "Caramelized Onions", "Fries", "Cole Slaw", "Guacamole", "Potato Chips", "Roasted Vegetables", "Milk", "Pujan's Secret Surprise"
    );
    ObservableList<String> sandwichChoices = FXCollections.observableArrayList(
            "Chicken", "Beef", "Fish"
    );
    ObservableList<String> extraList = FXCollections.observableArrayList(
    );
    @FXML
    ListView<String> availableExtras = new ListView<>(inputStrings);
    @FXML
    ListView<String> chosenExtras = new ListView<>(extraList);
    @FXML
    ComboBox<String> choicesCombo = new ComboBox<>(sandwichChoices);

    @FXML
    TextField basePrice;
    @FXML
    TextField totalPrice;
    @FXML
    TextField extraPrice;
    @FXML
    ImageView sandwichImage;
    @FXML
    TextArea basicIngredients;

    @FXML
    Label extraWarning;

    @FXML
    Button viewOrdersButton;

    /**
     * This method will run at the start of the program.
     * It will setup both listviews to work properly.
     * It will output the available extras to the listview.
     * It will also call selected() to make sure everything is displaying properly.
     */
    public void initialize()
    {
        availableExtras.setItems(inputStrings);
        availableExtras.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        chosenExtras.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        choicesCombo.setItems(sandwichChoices);
        choicesCombo.getSelectionModel().selectFirst();
        selected();
    }

    /**
     * Depending on what option is selected we will go in to a switch statement.
     * This method will change the basic ingredients, cost of sandwich, and picture depending on what sandwich type we select.
     * It will also make these types of sandwiches as objects to later add to the list.
     */
    @FXML
    public void selected()
    {
        String chickenBasic = "Basic Ingredients: \n" +
                              "- Fried Chicken\n" +
                              "- Spicy Sauce \n" +
                              "- Pickles";
        String beefBasic = "Basic Ingredients: \n" +
                "- Roast Beef\n" +
                "- Provolone Cheese \n" +
                "- Mustard";
        String fishBasic = "Basic Ingredients: \n" +
                "- Grilled Snapper\n" +
                "- Cilantro \n" +
                "- Lime";
        String choice = choicesCombo.getSelectionModel().getSelectedItem();
        Sandwich temp;
        if (sandwich != null)
        {
            temp = sandwich;
        }
        else
            temp = null;
        switch (choice)
        {
            case "Chicken":
                sandwich = new Chicken();
                sandwichImage.setImage(new Image("project4/chicken.jpg"));
                basicIngredients.clear();
                basicIngredients.appendText(chickenBasic);
                break;
            case "Beef":
                sandwich = new Beef();
                sandwichImage.setImage(new Image("project4/beef.jpg"));
                basicIngredients.clear();
                basicIngredients.appendText(beefBasic);
                break;
            case "Fish":
                sandwich = new Fish();
                sandwichImage.setImage(new Image("project4/fish.jpg"));
                basicIngredients.clear();
                basicIngredients.appendText(fishBasic);
                break;
            default:
        }
        if (temp != null)
        {
            sandwich.setList(temp.getList());
        }
        updatePrices();
    }

    /**
     * This method will look to see which extra is being chosen in the second list view.
     * It will then remove those from the list view and add them onto the extras available list view.
     * It will also update prices.
     */
    @FXML
    public void removeSelected()
    {
        for(Object obj : chosenExtras.getSelectionModel().getSelectedItems())
        {
            availableExtras.getItems().add(obj.toString());
        }
        for(Object obj : availableExtras.getItems()) //this is kind of silly but it works!
        {
            chosenExtras.getItems().remove(obj);
        }
        Collections.sort(availableExtras.getItems());
        Collections.sort(chosenExtras.getItems());

        ObservableList<String> availableList = availableExtras.getItems();
        for (String choices : availableList)
        {
            Extra temp = new Extra(choices);
            sandwich.remove(temp);
        }
        updatePrices();
    }

    /**
     * This will calculate the prices depending on how many extras are chosen and the sandwich type.
     * It will then set the calculations to the respective text fields.
     */
    @FXML
    public void updatePrices()
    {
        basePrice.setText(String.format("%,.02f",sandwich.getBasePrice()));
        extraPrice.setText(String.format("%,.02f",sandwich.getExtraPrice()));
        totalPrice.setText(String.format("%,.02f",(sandwich.getBasePrice() + sandwich.getExtraPrice())));
    }

    /**
     * This will find the selected items in the first list view.
     * Add them over to the chosen extras list view.
     * Then remove from the available extras list view.
     * It will also check for only 6 extras.
     * It will also update the prices.
     */
    @FXML
    public void addItems()
    {
        if (chosenExtras.getItems().size() < 6)
        {
            if (availableExtras.getSelectionModel().getSelectedItems().size() > 6 || chosenExtras.getItems().size() + availableExtras.getSelectionModel().getSelectedItems().size() > 6)
            {
                extraWarning.setVisible(true);
            }
            else
            {
                extraWarning.setVisible(false);
                for(Object obj : availableExtras.getSelectionModel().getSelectedItems())
                {
                    chosenExtras.getItems().add(obj.toString());
                }
                for(Object obj : chosenExtras.getItems())
                {
                    availableExtras.getItems().remove(obj);
                }
            }
        }
        else
        {
            extraWarning.setVisible(true);
        }

        Collections.sort(availableExtras.getItems());
        Collections.sort(chosenExtras.getItems());

        ObservableList<String> extrasList = chosenExtras.getItems();
        for (String choices : extrasList)
        {
            Extra temp = new Extra(choices);
            sandwich.add(temp);
        }
        updatePrices();
    }

    /**
     * This method is called whenever the order sandwiches button is used.
     * It will take all the stored information (sandwich type, extras, prices) and add it into an orderLine and then into the order list.
     * It will then reset everything for the next order.
     */
    @FXML
    public void orderSandwich()
    {
        priceDouble = Double.parseDouble(totalPrice.getText());
        OrderLine orderLine = new OrderLine(orderNum, sandwich, priceDouble);
        order.add(orderLine);

        for(Object obj : chosenExtras.getItems())
        {
            availableExtras.getItems().add(obj.toString());
        }
        for(Object obj : availableExtras.getItems())
        {
            chosenExtras.getItems().remove(obj);
        }
        Collections.sort(availableExtras.getItems());
        Collections.sort(chosenExtras.getItems());
        sandwich = null;
        selected();
    }

    /**
     * This method is called whenever a button is pressed.
     * It will then disable the current FXML Stage we are viewing and enable a seperate one to view our orders.
     * @throws IOException Checks for incorrect use of Scene changes.
     */
    @FXML
    public void viewOrders() throws IOException
    {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("orderFXML.fxml"));
        primaryStage.setTitle("Order Sandwich");
        primaryStage.setScene(new Scene(root, 1080, 720));

        Stage stage = (Stage) viewOrdersButton.getScene().getWindow();
        stage.close();

        primaryStage.show();
    }

}
