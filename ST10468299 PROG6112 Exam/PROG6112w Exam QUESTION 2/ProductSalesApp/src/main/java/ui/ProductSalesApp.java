package ui;

import product.ProductSales;
import product.IProductSales;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ProductSalesApp extends JFrame {
    private final JTextArea textArea;
    private final JLabel yearsProcessedLabel;
    private final JButton btnLoad;
    private final JButton btnSave;
    private IProductSales prodSales;
    private static final int SALES_LIMIT = 500;

    public ProductSalesApp() {
        super("Product Sales Manager");

        prodSales = new ProductSales();

        // Setup UI
        setLayout(new BorderLayout());

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu menuFile = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> dispose());
        menuFile.add(exitItem);

        // Tools menu
        JMenu menuTools = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");
        loadItem.addActionListener(e -> loadProductData());
        saveItem.addActionListener(e -> saveProductData());
        clearItem.addActionListener(e -> clearData());
        menuTools.add(loadItem);
        menuTools.add(saveItem);
        menuTools.add(clearItem);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // Buttons
        JPanel buttonPanel = new JPanel();
        btnLoad = new JButton("Load Product Data");
        btnLoad.addActionListener(e -> loadProductData());
        btnSave = new JButton("Save Product Data");
        btnSave.addActionListener(e -> saveProductData());
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);

        add(buttonPanel, BorderLayout.NORTH);

        // TextArea
        textArea = new JTextArea(16, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Status Panel
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        yearsProcessedLabel = new JLabel("Years Processed: 0");
        yearsProcessedLabel.setForeground(Color.BLUE);
        statusPanel.add(yearsProcessedLabel);
        add(statusPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void loadProductData() {
        prodSales = new ProductSales(); // Load from in-memory class
        StringBuilder builder = new StringBuilder();
        String[] productNames = {"Microphone", "Speakers", "Mixing Desk"};
        int[][] data = prodSales.GetProductSales();

        for (int year = 0; year < data.length; year++) {
            builder.append("Year ").append(year + 1).append(" Sales:\n");
            for (int product = 0; product < data[year].length; product++) {
                builder.append("  ").append(productNames[product]).append(": ").append(data[year][product]).append("\n");
            }
        }
        builder.append("\nTotal Sales: ").append(prodSales.GetTotalSales());
        builder.append("\nAverage Sales: ").append(String.format("%.2f", prodSales.GetAverageSales()));
        builder.append("\nSales over ").append(SALES_LIMIT).append(": ").append(prodSales.GetSalesOverLimit(SALES_LIMIT));
        builder.append("\nSales under ").append(SALES_LIMIT).append(": ").append(prodSales.GetSalesUnderLimit(SALES_LIMIT));

        textArea.setText(builder.toString());
        yearsProcessedLabel.setText("Years Processed: " + prodSales.GetProductProcessed());
    }

    private void saveProductData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "Product data saved to data.txt", "Save", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearData() {
        textArea.setText("");
        yearsProcessedLabel.setText("Years Processed: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesApp().setVisible(true));
    }
}





