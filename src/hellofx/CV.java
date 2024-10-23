// package hellofx;

// import com.itextpdf.text.BaseColor;
// import com.itextpdf.text.Document;
// import com.itextpdf.text.FontFactory;
// import com.itextpdf.text.Paragraph;
// import com.itextpdf.text.pdf.PdfPTable;
// import com.itextpdf.text.pdf.PdfWriter;
// import javax.swing.*;
// import javax.swing.filechooser.FileNameExtensionFilter;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.io.File;
// import java.io.FileOutputStream;

// public class CV extends JFrame{
//     private JPanel cvPanel;
//     private JTextField name;
//     private JTextField address;
//     private JTextField contact;
//     private JTextField email;
//     private JTextField skills1;
//     private JTextField skills2;
//     private JTextField skills3;
//     private JTextField skills4;
//     private JComboBox work;
//     private JTextField college;
//     private JTextField qualiA;
//     private JButton SELECTIMAGEButton;
//     private JLabel img;
//     private JButton GENERATERESUMEButton;
//     private JTextField qualiB;
//     private JTextField location;
//     JFrame frame = new JFrame();

//     public CV() {
//         cvPanel=new JPanel();
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setContentPane(cvPanel);
//         frame.pack();
//         frame.setLocationRelativeTo(null);
//         frame.setVisible(true);
//         SELECTIMAGEButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 JFileChooser fileChooser = new JFileChooser();
//                 FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png");
//                 fileChooser.addChoosableFileFilter(filter);
//                 int rs = fileChooser.showSaveDialog(null);
//                 if (rs == JFileChooser.APPROVE_OPTION) {
//                     File selectedImage = fileChooser.getSelectedFile();
//                     location.setText(selectedImage.getAbsolutePath());
//                     img.setIcon(resize(location.getText()));
//                 }
//             }
//         });
//         GENERATERESUMEButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 if (name.getText() == null || contact.getText() == null || address.getText() == null
//                         || email.getText() == null) {
//                     JOptionPane.showMessageDialog(null, "PLEASE ENTER ALL DETAILS TO GENERATE CV");
//                 } else {
//                     try {
//                         String nameOfFile = "C:\\Users\\govin\\Downloads\\noyam cv.pdf";
//                         Document myDocument = new Document();
//                         PdfWriter.getInstance(myDocument, new FileOutputStream(nameOfFile));
//                         myDocument.open();
//                         com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(location.getText());
//                         img.setAbsolutePosition(473f, 750f);
//                         img.scaleAbsolute(80f, 70f);
//                         PdfPTable table = new PdfPTable(2);
//                         myDocument.add(img);
//                         myDocument.add(new Paragraph(name.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 32,
//                                 com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY)));
//                         myDocument.add(
//                                 new Paragraph("", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, BaseColor.DARK_GRAY)));
//                         myDocument.add(
//                                 new Paragraph("", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph(
//                                 "----------------------------------------------------------------------------------------------------------------------------------"));
//                         myDocument.add(new Paragraph("CONTACT DETAILS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9,
//                                 com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph(email.getText(),
//                                 FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph(contact.getText(),
//                                 FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph(address.getText(),
//                                 FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph(
//                                 "----------------------------------------------------------------------------------------------------------------------------------"));
//                         myDocument.add(new Paragraph("SKILLS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9,
//                                 com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY)));
//                         table.setHeaderRows(1);
//                         table.addCell(skills1.getText());
//                         table.addCell(skills2.getText());
//                         table.addCell(skills3.getText());
//                         table.addCell(skills4.getText());
//                         myDocument.add(table);
//                         myDocument.add(new Paragraph(
//                                 "----------------------------------------------------------------------------------------------------------------------------------"));
//                         myDocument.add(new Paragraph("QUALIFICATIONS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9,
//                                 com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph(college.getText(),
//                                 FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph(qualiA.getText(),
//                                 FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph(qualiB.getText(),
//                                 FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph(
//                                 "----------------------------------------------------------------------------------------------------------------------------------"));
//                         myDocument.add(new Paragraph("WORK EXPERIENCE", FontFactory.getFont(FontFactory.TIMES_BOLD, 10,
//                                 com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph("" + work.getSelectedItem(),
//                                 FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph(
//                                 "----------------------------------------------------------------------------------------------------------------------------------"));
//                         myDocument.add(new Paragraph("REFERENCES", FontFactory.getFont(FontFactory.TIMES_BOLD, 9,
//                                 com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY)));
//                         myDocument.add(new Paragraph("Available upon request",
//                                 FontFactory.getFont(FontFactory.TIMES_BOLD, 6, BaseColor.DARK_GRAY)));
//                         myDocument.close();
//                         JOptionPane.showMessageDialog(null, "CV was successfully generated");
//                     } catch (Exception ex) {
//                         JOptionPane.showMessageDialog(null, ex);
//                     }
//                 }
//             }
//         });
//     }

//     public ImageIcon resize(String path) {
//         ImageIcon myImg = new ImageIcon(path);
//         Image image = myImg.getImage();
//         Image newImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//         ImageIcon finalImage = new ImageIcon(newImage);
//         return finalImage;
//     }
// }
package hellofx;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

public class CV extends JFrame {
    private JPanel cvPanel;
    private JTextField name;
    private JTextField address;
    private JTextField contact;
    private JTextField email;
    private JTextField skills1;
    private JTextField skills2;
    private JTextField skills3;
    private JTextField skills4;
    private JComboBox<String> work;
    private JTextField college;
    private JTextField qualiA;
    private JTextField qualiB;
    private JButton selectImageButton;
    private JLabel img;
    private JButton generateResumeButton;
    private JTextField location;

    public CV() {
        setTitle("CV Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);

        // Initialize components
        cvPanel = new JPanel();
        name = new JTextField(20);
        address = new JTextField(20);
        contact = new JTextField(20);
        email = new JTextField(20);
        skills1 = new JTextField(20);
        skills2 = new JTextField(20);
        skills3 = new JTextField(20);
        skills4 = new JTextField(20);
        work = new JComboBox<>(new String[]{"Select Work Experience", "Job 1", "Job 2"});
        college = new JTextField(20);
        qualiA = new JTextField(20);
        qualiB = new JTextField(20);
        location = new JTextField(20);
        location.setEditable(false);
        
        selectImageButton = new JButton("Select Image");
        generateResumeButton = new JButton("Generate Resume");
        img = new JLabel();

        // Layout
        cvPanel.setLayout(new GridLayout(16, 2, 10, 10));
        cvPanel.add(new JLabel("Name:"));
        cvPanel.add(name);
        cvPanel.add(new JLabel("Address:"));
        cvPanel.add(address);
        cvPanel.add(new JLabel("Contact:"));
        cvPanel.add(contact);
        cvPanel.add(new JLabel("Email:"));
        cvPanel.add(email);
        cvPanel.add(new JLabel("Skills 1:"));
        cvPanel.add(skills1);
        cvPanel.add(new JLabel("Skills 2:"));
        cvPanel.add(skills2);
        cvPanel.add(new JLabel("Skills 3:"));
        cvPanel.add(skills3);
        cvPanel.add(new JLabel("Skills 4:"));
        cvPanel.add(skills4);
        cvPanel.add(new JLabel("Work Experience:"));
        cvPanel.add(work);
        cvPanel.add(new JLabel("College:"));
        cvPanel.add(college);
        cvPanel.add(new JLabel("Qualification A:"));
        cvPanel.add(qualiA);
        cvPanel.add(new JLabel("Qualification B:"));
        cvPanel.add(qualiB);
        cvPanel.add(new JLabel("Image Location:"));
        cvPanel.add(location);
        cvPanel.add(selectImageButton);
        cvPanel.add(img);
        cvPanel.add(generateResumeButton);

        add(cvPanel);

        // Add Action Listeners
        selectImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(CV.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedImage = fileChooser.getSelectedFile();
                    location.setText(selectedImage.getAbsolutePath());
                    img.setIcon(resize(location.getText()));
                }
            }
        });

        generateResumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().isEmpty() || contact.getText().isEmpty() || address.getText().isEmpty() || email.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(CV.this, "Please enter all details to generate CV");
                } else {
                    try {
                        String nameOfFile = "C:\\Users\\govin\\Downloads\\resumebyme.pdf";
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream(nameOfFile));
                        document.open();
                        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(location.getText());
                        img.setAbsolutePosition(473f, 750f);
                        img.scaleAbsolute(80f, 70f);
                        PdfPTable table = new PdfPTable(2);
                        document.add(img);
                        document.add(new Paragraph(name.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 32, Font.BOLD, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph("CONTACT DETAILS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph(email.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph(contact.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph(address.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph("SKILLS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        table.addCell(skills1.getText());
                        table.addCell(skills2.getText());
                        table.addCell(skills3.getText());
                        table.addCell(skills4.getText());
                        document.add(table);
                        document.add(new Paragraph("QUALIFICATIONS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph(college.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph(qualiA.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph(qualiB.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph("WORK EXPERIENCE", FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.BOLD, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph(work.getSelectedItem().toString(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph("REFERENCES", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.BOLD, BaseColor.DARK_GRAY)));
                        document.add(new Paragraph("Available upon request", FontFactory.getFont(FontFactory.TIMES_BOLD, 6, BaseColor.DARK_GRAY)));
                        document.close();
                        JOptionPane.showMessageDialog(CV.this, "CV was successfully generated");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(CV.this, "Error generating CV: " + ex.getMessage());
                    }
                }
            }
        });

        // Make the JFrame visible
        setVisible(true);
    }

    private ImageIcon resize(String path) {
        ImageIcon myImg = new ImageIcon(path);
        Image image = myImg.getImage();
        Image newImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new CV();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
