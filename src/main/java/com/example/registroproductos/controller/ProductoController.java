package com.example.registroproductos.controller;

import com.example.registroproductos.model.Producto;
import com.example.registroproductos.repository.ProductoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.time.LocalDate;

public class ProductoController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCategoria;
    @FXML
    private DatePicker dtpFechaRegistro;
    @FXML
    private TextField txtPrecio;
    @FXML
    private ImageView imgProducto;
    @FXML
    private TableView<Producto> tblProductos;
    @FXML
    private TableColumn<Producto, Integer> colid;
    @FXML
    private TableColumn<Producto, String> colNombre;
    @FXML
    private TableColumn<Producto, String> colCategoria;
    @FXML
    private TableColumn<Producto, Double> colPrecio;
    @FXML
    private TableColumn<Producto, LocalDate> colFechaIngreso;
    private final ObservableList<Producto> productos = FXCollections.observableArrayList();
    private final ProductoRepository productoRepository = new ProductoRepository();

    private String selectedImagePath;
    @FXML
    private void initialize(){
        configureTable();
        configureDatePicker();
        loadInitialData();
        configureTableSelection();
    }
    private void configureTable(){
        colid.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        colFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("FechaRegistro"));
        tblProductos.setItems(productos);
    }
    private void configureDatePicker(){
        dtpFechaRegistro.setValue(LocalDate.now());

    }
    private void loadInitialData(){
        productos.clear();
        productos.setAll(productoRepository.findAll());
    }
    @FXML
    private void configureTableSelection(){
        tblProductos.getSelectionModel().selectedItemProperty()
                .addListener((observable,oldValue,newValue)->{
                        if(newValue!=null) {
                           loadProductoIntoForm(newValue);
                        }
                });
    }
    private void loadProductoIntoForm(Producto producto){
        txtNombre.setText(producto.getNombre());
        txtCategoria.setText(producto.getCategoria());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        dtpFechaRegistro.setValue(producto.getFechaRegistro());
        selectedImagePath = producto.getImagePath();
        //agregar el metodo de showImage
    }
    private boolean validateForm(){
        String nombre = txtNombre.getText().trim();
        String categoria = txtCategoria.getText().trim();
        String precio = txtPrecio.getText().trim();
        if(nombre.isEmpty() || categoria.isEmpty() || precio.isEmpty()){
            showAlert(
                    Alert.AlertType.WARNING,
                    "Datos incompletos",
                    "Complete todos los campos para continuar"
            );
            return false;
        }
        return true;
    }
    private void showAlert(Alert.AlertType type, String title, String message){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    private void agregarProducto(){
        if(!validateForm()){
            return;
        }
        Producto producto = new Producto(
                1,
                txtNombre.getText().trim(),
                txtCategoria.getText().trim(),
                Double.parseDouble(txtPrecio.getText()),
                dtpFechaRegistro.getValue(),
                selectedImagePath
        );
        productos.add(producto);
        showAlert(
                Alert.AlertType.INFORMATION,
                "Productos creados",
                "Creado con exito"
        );

    }
    @FXML
    private void guardarImage(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccione la imagen del producto");
        fileChooser.getExtensionFilters().add(new
                FileChooser.ExtensionFilter("Imgenes", "*.jpg", "*png", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(imgProducto.getScene().getWindow());
        if(selectedFile != null){
            selectedImagePath = selectedFile.toURI().toString();
            showImage(selectedImagePath);
        }

    }
    private void showImage(String selectedImagePath){
        if(selectedImagePath== null){
            imgProducto.setImage(null);
        }
        Image image = new Image(selectedImagePath,180,150,true,true);
        imgProducto.setImage(image);
    }
    public void actualizarProducto(ActionEvent actionEvent){

    }
    public void limpiarControles(ActionEvent actionEvent){}


}
