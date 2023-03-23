package com.librery;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JCTextField extends JTextField {
  private Dimension d = new Dimension(200, 32);
  
  private String placeholder = "";
  
  private Color phColor = new Color(0, 0, 0);
  
  private boolean band = true;
  
  public JCTextField() {
    setSize(this.d);
    setPreferredSize(this.d);
    setVisible(true);
    setMargin(new Insets(3, 6, 3, 6));
    getDocument().addDocumentListener(new DocumentListener() {
          public void removeUpdate(DocumentEvent e) {
            JCTextField.this.band = !(JCTextField.this.getText().length() > 0);
          }
          
          public void insertUpdate(DocumentEvent e) {
            JCTextField.this.band = false;
          }
          
          public void changedUpdate(DocumentEvent de) {}
        });
  }
  
  public void setPlaceholder(String placeholder) {
    this.placeholder = placeholder;
  }
  
  public String getPlaceholder() {
    return this.placeholder;
  }
  
  public Color getPhColor() {
    return this.phColor;
  }
  
  public void setPhColor(Color phColor) {
    this.phColor = phColor;
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(this.phColor.getRed(), this.phColor.getGreen(), this.phColor.getBlue(), 90));
    g.drawString(this.band ? this.placeholder : "", 
        (getMargin()).left, 
        (getSize()).height / 2 + getFont().getSize() / 2);
  }
}