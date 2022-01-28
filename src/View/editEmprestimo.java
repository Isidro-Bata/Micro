/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author nazar
 */
public class editEmprestimo extends JDialog{
    JPanel ctn,addEmp;
    JLabel lblTit, lblID,perfil;
    JTextField inID;
    JButton btnSearch, btnVer, btnValidar,btnCancelar;
    //painel ADD;
    JLabel txtID,txtCred,txtNum,txtVpr,txtVt,txtGar,txtJur, txtRem,txtFuncio;
    JTextField Id,inCred,inNum,inVt,inVpr,inGar,inJr,inRem,inFunc;
    
    public editEmprestimo(){
        setSize(800,480);
        setTitle("Empréstimo");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setModal(true);//Quando Aberta, nenhuma outra podera ser aberta
        setLocationRelativeTo(null);
        
        ctn=new JPanel();
        ctn.setLayout(null);
        ctn.setBackground(new java.awt.Color(237, 237, 237));
        add(ctn);
        
        Font ftTit=new Font("Courier",Font.BOLD, 16);
        //Borda do Titulo
        JPanel Borda = new JPanel();
        Borda.setLayout(null);
        Borda.setBounds(0,0,800,65);
        Borda.setBackground(new java.awt.Color(58,70,80));
        //Titulo
        lblTit=new JLabel("Empréstimo");
        lblTit.setForeground(Color.WHITE);
        lblTit.setFont(ftTit);
        lblTit.setHorizontalAlignment(SwingConstants.LEFT);
        lblTit.setBounds(50,15,100,35);
        Borda.add(lblTit);
        //Pesquisa
        lblID=new JLabel("Digite o ID do Cliente");
        lblID.setBounds(50,90,170,25);
        inID=new JTextField();
        inID.setBounds(180,90,100,25);
        btnSearch=new JButton("Procurar");
        btnSearch.setBounds(280,90,100,25);
        btnSearch.setBackground(new java.awt.Color(0, 223, 186));
        
        JSeparator sep=new JSeparator(JSeparator.HORIZONTAL);
        sep.setBounds(50,140,700,2);
        sep.setForeground(Color.black);
        
        //painel ADD
        addEmp=new JPanel();
        addEmp.setBounds(50,165,700,265);
        addEmp.setBackground(Color.white);
        addEmp.setBorder(BorderFactory.createLineBorder(Color.black));
        addEmp.setLayout(null);
        
        painelADD();
        
        ctn.add(addEmp);
        ctn.add(sep);
        ctn.add(lblID);
        ctn.add(inID);
        ctn.add(btnSearch);
        ctn.add(Borda);
        setVisible(true);
    }
    public void painelADD(){
        addEmp.removeAll();
        addEmp.revalidate();
        addEmp.repaint();
        //perfil icon
        perfil=new JLabel();
        perfil.setBorder(BorderFactory.createLineBorder(Color.black));
        perfil.setBounds(30,30,160,190);
        //
        txtID=new JLabel("ID Cliente:");
        txtID.setBounds(200,30,70,20);
        Id=new JTextField();
        Id.setEditable(false);
        Id.setBounds(320,30,50,20);
        
        txtCred=new JLabel("Crédito:");
        txtCred.setBounds(200,60,70,20);
        inCred=new JTextField();
        inCred.setBounds(320,60,100,20);
        
        txtNum=new JLabel("Nr de Prestações:");
        txtNum.setBounds(480,60,120,20);
        inNum=new JTextField();
        inNum.setBounds(600,60,50,20);
        
        txtGar=new JLabel("Garantias:");
        txtGar.setBounds(200,90,70,20);
        inGar=new JTextField();
        inGar.setBounds(320,90,100,20);
        
        //botao para verificar aprovação
        btnVer=new JButton("Verificar");
        btnVer.setBounds(480,90,170,20);
        btnVer.setBackground(new java.awt.Color(0, 223, 186));
        //
        txtVt=new JLabel("Valor Ajuízado:");
        txtVt.setBounds(200,130,120,20);
        inVt=new JTextField();
        inVt.setBounds(320,130,100,20);
        inVt.setEditable(false);
        
        txtJur=new JLabel("Juros:");
        txtJur.setBounds(480,130,50,20);
        inJr=new JTextField();
        inJr.setBounds(600,130,50,20);
        inJr.setEditable(false);
        
        txtVpr=new JLabel("Valor Mensal:");
        txtVpr.setBounds(200,160,120,20);
        inVpr=new JTextField();
        inVpr.setBounds(320,160,100,20);
        inVpr.setEditable(false);
        
        txtFuncio=new JLabel("ID Funcionário:");
        txtFuncio.setBounds(200,190,120,20);
        inFunc=new JTextField();
        inFunc.setBounds(320,190,50,20);
        inFunc.setEditable(false);
        //Botao Cancelar e Aprovar
        btnValidar=new JButton("Aprovar");
        btnValidar.setBounds(290,225,170,20);
        btnValidar.setBackground(new java.awt.Color(0, 223, 186));
        
        btnCancelar=new JButton("Cancelar");
        btnCancelar.setBounds(480,225,170,20);
        btnCancelar.setBackground(new java.awt.Color(0, 223, 186));
        //
        JSeparator sepH=new JSeparator(JSeparator.HORIZONTAL);
        sepH.setBounds(200,120,450,2);
        sepH.setForeground(Color.black);
       
        addEmp.add(btnValidar);
        addEmp.add(btnCancelar);
        addEmp.add(txtFuncio);
        addEmp.add(inFunc);
        addEmp.add(inVt);
        addEmp.add(inVpr);
        addEmp.add(inJr);
        addEmp.add(txtVt);
        addEmp.add(txtJur);
        addEmp.add(txtVpr);
        addEmp.add(sepH);
        addEmp.add(btnVer);
        addEmp.add(perfil);
        addEmp.add(txtID);
        addEmp.add(txtCred);
        addEmp.add(txtNum);
        addEmp.add(txtGar);
        addEmp.add(Id);
        addEmp.add(inCred);
        addEmp.add(inNum);
        addEmp.add(inGar);
    }
    
    public static void main(String[] args) {
        new editEmprestimo();
    }
}
