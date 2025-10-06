package com.example.teste_javafx.controller;

import com.example.teste_javafx.model.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.DecimalFormat;

public class MainController {

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
    int proximoID = 0;

    Pessoa pessoa = new Pessoa();

    @FXML
    protected void onCalcularIMCClick(){
        DecimalFormat df = new DecimalFormat();

        this.pessoa.setNome(this.txtNome.getText());
        this.pessoa.setAltura(Float.parseFloat(this.txtAltura.getText()));
        this.pessoa.setPeso(Float.parseFloat(this.txtPeso.getText()));


        df.applyPattern("#0.00");
        this.lbIMC.setText(df.format(this.pessoa.calcularIMC()));
        this.lbclassificacao.setText(this.pessoa.classificacaoIMC());
    }

    @FXML
    protected void onSalvarIMCClick(){

        String nome = txtNome.getText();
        float altura = Float.parseFloat(txtAltura.getText());
        float peso = Float.parseFloat(txtPeso.getText());
        float valorImc = this.pessoa.calcularIMC();
        colunaID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        colunaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colunaIMC.setCellValueFactory(new PropertyValueFactory<>("imc"));

        int novoID = ++proximoID;

        Pessoa novaLinha = new Pessoa(novoID, nome, altura, peso, valorImc);

        tabelaDados.getItems().add(novaLinha);
        }

        @FXML
        protected void onCarregarDadosIMC(){



    }
}
