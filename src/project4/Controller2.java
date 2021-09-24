package project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class will be used to control the orderFXML.fxml file.
 * The controller is in charge of making all of the GUI elements to be made, appear, and make it so we can interact with them.
 * The controller will also handle accessing our original controller and FXML.
 * We will also handle a majority of the output, removing pre-existing orders, or copying orders, or clearing all order all together.
 * @Authors Pujan Pate and Martin Colucci.
 */
public class Controller2
{
    @FXML
    TextArea outputArea;
    @FXML
    TextField orderField;
    @FXML
    Button returnOrderButton;
    @FXML
    Label orderWarning;


    Order orders = Controller.order;
    ArrayList<OrderLine> orderList = orders.getList();

    /**
     * This method is called when the program starts.
     * It will print the current order list to the text area.
     */
    public void initialize()
    {
        printOrder();
    }

    /**
     * This method is used to clear the text area and output the order list onto it using a seperate method.
     */
    public void printOrder()
    {
        outputArea.clear();
        outputArea.appendText(orderString());
    }

    /**
     * This order will return a string of all sandwich orders with its sandwich type, included ingredients, chosen extras, and price outputted.
     * @return Returns a string to then output onto a text area or an outputfile.txt.
     */
    public String orderString()
    {
        double total = 0;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < orderList.size(); i++)
        {
            output.append("Order ").append(orderList.get(i).getIndex()).append(" ").append(orderList.get(i).getSandwich().toString()).append("\n");
            total+= orderList.get(i).outputPrice();
        }
        output.append("Total Price : $").append(String.format("%,.02f", total));
        return output.toString();
    }

    /**
     * This is called when the button is pressed.
     * It will use a given order number from a text label.
     * Using the order number it will remove the order from the order list and re update the text area.
     */
    @FXML
    public void removeOrder()
    {
        int orderNumber = -1;
        try
        {
            orderNumber = Integer.parseInt(orderField.getText()) - 1;
        }
        catch (Exception e)
        {
            orderWarning.setVisible(true);
        }
        if (orderNumber < 0 || orderNumber > orderList.size() - 1)
        {
            orderWarning.setVisible(true);
        }
        else
        {
            orderWarning.setVisible(false);
            orders.remove(orderList.get(orderNumber));
            printOrder();
        }
    }
    /**
     * This is called when the button is pressed.
     * Using the order number it will remove all orders from the order list and re update the text area.
     */
    @FXML
    public void removeAll()
    {
        while (orderList.size() != 0)
        {
            orderList.remove(0);
        }
        printOrder();
    }

    /**
     * THis is used to switch back to the original Stage from our original FXML.
     * @throws IOException Cheks to make sure we aren't using scene changes in incorrect ways.
     */
    @FXML
    public void returnOrder() throws IOException
    {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("project4.fxml"));
        primaryStage.setTitle("Order Sandwich");
        primaryStage.setScene(new Scene(root, 1080, 720));

        Stage stage = (Stage) returnOrderButton.getScene().getWindow();
        stage.close();
        primaryStage.show();
    }

    /**
     * This method is used to output our orderlist into an output file.
     * It will use our outputString method which creates a list of orders and their attributes to output into a separate file.
     * @throws IOException Checks to see if we are writing correctly.
     */
    @FXML
    public void exportOrder() throws IOException
    {
        FileWriter writer = new FileWriter("./src/project4/outputfiles/output.txt");
        writer.write(orderString());
        writer.close();
    }

    /**
     * This is called when the button is pressed.
     * It will use a given order number from a text label.
     * Using the order number it will copy the specific order using its number, create a copy of that order, and add it onto the end of the list.
     */
    public void copyOrder()
    {
        int orderNumber = -1;
        try
        {
            orderNumber = Integer.parseInt(orderField.getText()) - 1;
        }
        catch (Exception e)
        {
            orderWarning.setVisible(true);
        }
        if (orderNumber < 0 || orderNumber > orderList.size() - 1)
        {
            orderWarning.setVisible(true);
        }
        else
        {
            orderWarning.setVisible(false);
            OrderLine temp = new OrderLine(orderList.size()+1, orderList.get(orderNumber).getSandwich(), orderList.get(orderNumber).outputPrice());
            orderList.add(temp);
            printOrder();
        }
    }
}
