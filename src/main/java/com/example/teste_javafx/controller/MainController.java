package com.example.teste_javafx.controller;

import com.example.teste_javafx.model.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public TextField txtNome;
    @FXML
    public TextField txtAltura;
    @FXML
    public TextField txtPeso;
    @FXML
    public Label lbIMC;
    @FXML
    public Label lbclassificacao;
    @FXML
    private TableView<Pessoa> tabelaDados;
    @FXML
    private TableColumn<Pessoa, Integer> colunaID;
    @FXML
    private TableColumn<Pessoa, String> colunaNome;
    @FXML
    private TableColumn<Pessoa, Double> colunaAltura;
    @FXML
    private TableColumn<Pessoa, Double> colunaPeso;
    @FXML
    private TableColumn<Pessoa, Double> colunaIMC;
    private int proximoID = 0;


    Pessoa pessoa;
    List<Pessoa> listaPessoas;
    ObservableList<Pessoa> observableListPessoas;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.pessoa = new Pessoa();
        this.listaPessoas = new ArrayList<>();
        vinculoComTabela();
    }

    public void vinculoComTabela() {
        colunaID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        colunaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colunaIMC.setCellValueFactory(new PropertyValueFactory<>("imc"));
    }

    public void lerFormulario() {
        this.pessoa.setNome(txtNome.getText());
        this.pessoa.setPeso(Float.parseFloat(txtPeso.getText()));
        this.pessoa.setAltura(Float.parseFloat(txtAltura.getText()));
    }

    public void atualizarTableView() {
        this.listaPessoas.forEach(obj -> System.out.printf(obj.getNome() + ", " + obj.getPeso() + ", " + obj.getAltura() + "\n"));
        this.observableListPessoas = FXCollections.observableList(this.listaPessoas);
        this.tabelaDados.setItems(this.observableListPessoas);
    }

    public void exibirClassificacaoIMC() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("#0.00");
        lbIMC.setText(df.format(this.pessoa.calcularIMC()));
        lbclassificacao.setText(this.pessoa.classificacaoIMC());
    }


    @FXML
    protected void onCalcularIMCClick() {
        lerFormulario();
        this.pessoa.classificacaoIMC();
        exibirClassificacaoIMC();
        System.out.println(this.pessoa.toString());
    }

    @FXML
    protected void onSalvarIMCClick() {
        lerFormulario();
        int novoID = ++proximoID;
        this.pessoa.setID(novoID);
        this.listaPessoas.add(pessoa);
        atualizarTableView();
    }

    @FXML
    protected void onCarregarDadosIMC() {
        this.pessoa = new Pessoa();
        txtNome.setText("");
        txtPeso.setText("");
        txtAltura.setText("");
    }
}
