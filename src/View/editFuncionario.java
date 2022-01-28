/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ctrCliente;
import Controller.ctrFuncionario;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author nazar
 */
public class editFuncionario extends JDialog implements ActionListener {
    
    Container ctn;
    JLabel lblTit, perfil,txtID,txtNome,txtData,txtEst,txtBI,txtMorada,txtSal,txtCont,txtSexo;
    JTextField entryID,entryNome,entryData,entryEst,entryBI,entryMorada,entrySal,entryCont,entrySexo;
    JComboBox <String> jcbSexo,jcbEst;
    JButton btnSave,btnCancel, btnRemove;
    
    public editFuncionario(int id, int nasci, String nome,String bi, String sx,float salario, int ctt){
        setSize(900,380);
        setTitle("EDIT Funcionário");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setModal(true);//Quando Aberta, nenhuma outra podera ser aberta
        setLocationRelativeTo(null);
        
        ctn=getContentPane();
        ctn.setLayout(null);
        ctn.setBackground(Color.WHITE);
        
        Font ftTit=new Font("Courier",Font.BOLD, 16);
        //Borda do Titulo
        JPanel Borda = new JPanel();
        Borda.setLayout(null);
        Borda.setBounds(0,0,900,50);
        Borda.setBackground(new java.awt.Color(58,70,80));
        //Titulo
        lblTit=new JLabel("Editar informações do Funcionário");
        lblTit.setForeground(Color.WHITE);
        lblTit.setFont(ftTit);
        lblTit.setHorizontalAlignment(SwingConstants.LEFT);
        lblTit.setBounds(50,10,280,30);
        Borda.add(lblTit);
        //Profile Pic
        perfil=new JLabel();
        perfil.setBorder(BorderFactory.createLineBorder(Color.black));
        perfil.setBounds(30,90,170,190);
        //Labels
        JSeparator sep=new JSeparator(JSeparator.HORIZONTAL);
        sep.setForeground(Color.black);
        sep.setBounds(220,280,630,2);
        ctn.add(sep);
        
        txtID=new JLabel("ID Funcionário:");
        txtID.setBounds(220,90,100,20);
        entryID=new JTextField();
        entryID.setBounds(370,90,100,20);
        entryID.setText(Integer.toString(id));
        entryID.setEditable(false);
        
        txtNome=new JLabel("Nome:");
        txtNome.setBounds(220,130,100,20);
        entryNome=new JTextField(nome);
        entryNome.setBounds(370,130,200,20);
        
        txtSexo=new JLabel("Sexo:");
        txtSexo.setBounds(220,210,100,20);
        jcbSexo=new JComboBox();
        if(sx.equals("Masculino")){
            jcbSexo.addItem("Masculino");
            jcbSexo.addItem("Femenino");}
        if(sx.equals("Femenino")){
            jcbSexo.addItem("Femenino");
            jcbSexo.addItem("Masculino");
        }
        jcbSexo.setBounds(370,210,100,20);
        
        txtData=new JLabel("Ano Nascimento:");
        txtData.setBounds(220,170,100,20);
        entryData=new JTextField(Integer.toString(nasci));
        entryData.setBounds(370,170,50,20);
        
        
        txtBI=new JLabel("Nr de BI:");
        txtBI.setBounds(620,210,90,20);
        entryBI=new JTextField(bi);
        entryBI.setBounds(710,210,120,20);
        
        
        txtSal=new JLabel("Salário:");
        txtSal.setBounds(220,250,150,20);
        entrySal=new JTextField(Float.toString(salario));
        entrySal.setBounds(370,250,100,20);
        
        txtCont=new JLabel("Contacto:");
        txtCont.setBounds(620,250,90,20);
        entryCont=new JTextField(Integer.toString(ctt));
        entryCont.setBounds(710,250,120,20);
        //Botoes save e remove
        btnSave=new JButton("SALVAR");
        btnSave.setBackground(new java.awt.Color(0, 223, 186));
        btnSave.setForeground(Color.black);
        btnSave.setBounds(370,300,100,30);
        btnSave.addActionListener(this);
        
        btnCancel=new JButton("CANCELAR");
        btnCancel.setBackground(new java.awt.Color(0, 223, 186));
        btnCancel.setForeground(Color.black);
        btnCancel.setBounds(490,300,100,30);
        btnCancel.addActionListener(this);
        
        btnRemove=new JButton("Remover Funcionário");
        btnRemove.setBackground(Color.red);
        btnRemove.setForeground(Color.white);
        btnRemove.setBounds(610,300,160,30);
        btnRemove.addActionListener(this);
        
        //
        ctn.add(btnRemove);
        ctn.add(btnCancel);
        ctn.add(btnSave);
        ctn.add(txtID);
        ctn.add(txtNome);
        ctn.add(txtData);
        ctn.add(txtBI);
        ctn.add(txtSal);
        ctn.add(txtCont);
        ctn.add(txtSexo);
        ctn.add(jcbSexo);
        ctn.add(entryID);
        ctn.add(entryNome);
        ctn.add(entryData);
        ctn.add(entryBI);
        ctn.add(entrySal);
        ctn.add(entryCont);
        ctn.add(perfil);
        ctn.add(Borda);
        
        this.setVisible(true);
    }
    
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btnSave){
            boolean scc;
            ctrFuncionario ctr=new ctrFuncionario();
            try{
                scc=ctr.modificar(Integer.parseInt(entryID.getText()),Integer.parseInt(entryData.getText()), entryNome.getText(),
                        entryBI.getText(), jcbSexo.getSelectedItem().toString(),
                        Float.parseFloat(entrySal.getText()), Integer.parseInt(entryCont.getText()));
                if(scc){
                        JOptionPane.showMessageDialog(null, "Actualizado Com Sucesso!");
                        dispose();
                } else{
                        JOptionPane.showMessageDialog(null, "Os Campos não foram preenchidos Correctamente!");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERRO:"+e);
            }
       
        }
        if(ae.getSource()==btnCancel){
            int yes_no=JOptionPane.showConfirmDialog(null, "Tem Certeza?","Confirm",JOptionPane.YES_NO_OPTION);
            if(yes_no==JOptionPane.YES_OPTION){
                dispose();
            }
        }
        if(ae.getSource()==btnRemove){
            boolean scc;
            try{
                ctrFuncionario ctr=new ctrFuncionario();
                scc=ctr.remover(Integer.parseInt(entryID.getText()));
                if(scc){
                    JOptionPane.showMessageDialog(null, "Deletado Com Sucesso!");
                    dispose();
                } else{
                    JOptionPane.showMessageDialog(null, "Erro!");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro: "+e);
            }
        }
    }
    
}
