package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Step 1: Create a Sign-In Form
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button signInButton = new Button("Sign In");
        signInButton.setOnAction(e -> {
            if (usernameField.getText().equals("admin") && passwordField.getText().equals("1234")) {
                // Switch to second scene after successful login
                switchToSecondScene(primaryStage);
            } else {
                System.out.println("Invalid credentials");
            }
        });

        VBox signInLayout = new VBox(10);
        signInLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, signInButton);
        Scene signInScene = new Scene(signInLayout, 300, 250);

        // Set the sign-in scene as the first scene
        primaryStage.setTitle("Sign-In");
        primaryStage.setScene(signInScene);
        primaryStage.show();
    }

    private void switchToSecondScene(Stage primaryStage) {
        // Step 2: Create a simple table and data collection form
        TableView<Order> table = new TableView<>();

        // Set up the columns for the table
        TableColumn<Order, String> orderNumberColumn = new TableColumn<>("Order Number");
        orderNumberColumn.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));

        TableColumn<Order, String> itemNameColumn = new TableColumn<>("Item Name");
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));

        TableColumn<Order, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Order, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Order, String> customerNameColumn = new TableColumn<>("Customer Name");
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<Order, String> orderDateColumn = new TableColumn<>("Order Date");
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));

        TableColumn<Order, String> shippingAddressColumn = new TableColumn<>("Shipping Address");
        shippingAddressColumn.setCellValueFactory(new PropertyValueFactory<>("shippingAddress"));

        table.getColumns().addAll(orderNumberColumn, itemNameColumn, quantityColumn, priceColumn, customerNameColumn, orderDateColumn, shippingAddressColumn);

        // Create a simple form to add orders
        TextField orderNumberField = new TextField();
        TextField itemNameField = new TextField();
        TextField quantityField = new TextField();
        TextField priceField = new TextField();
        TextField customerNameField = new TextField();
        TextField orderDateField = new TextField();
        TextField shippingAddressField = new TextField();

        Button addButton = new Button("Add Order");
        addButton.setOnAction(e -> {
            String orderNumber = orderNumberField.getText();
            String itemName = itemNameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            String customerName = customerNameField.getText();
            String orderDate = orderDateField.getText();
            String shippingAddress = shippingAddressField.getText();

            // Create a new order and add it to the table
            Order newOrder = new Order(orderNumber, itemName, quantity, price, customerName, orderDate, shippingAddress);
            table.getItems().add(newOrder);
        });

        // Layout for second scene (including table and form)
        VBox secondSceneLayout = new VBox(10);
        secondSceneLayout.getChildren().addAll(
                new Label("Order Number:"), orderNumberField,
                new Label("Item Name:"), itemNameField,
                new Label("Quantity:"), quantityField,
                new Label("Price:"), priceField,
                new Label("Customer Name:"), customerNameField,
                new Label("Order Date:"), orderDateField,
                new Label("Shipping Address:"), shippingAddressField,
                addButton, table
        );

        Scene secondScene = new Scene(secondSceneLayout, 600, 400);

        // Set the second scene
        primaryStage.setScene(secondScene);
    }

    // Order class to hold data
    public static class Order {
        private String orderNumber;
        private String itemName;
        private int quantity;
        private double price;
        private String customerName;
        private String orderDate;
        private String shippingAddress;

        public Order(String orderNumber, String itemName, int quantity, double price, String customerName, String orderDate, String shippingAddress) {
            this.orderNumber = orderNumber;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
            this.customerName = customerName;
            this.orderDate = orderDate;
            this.shippingAddress = shippingAddress;
        }

        // Getters and setters for all attributes
        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public String getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
        }
    }
}