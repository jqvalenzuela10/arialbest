package vista;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartTheme;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import model.RoundedCornerBorder;
import utils.clsArial;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntDashBoard extends JInternalFrame {
	private JPanel pnlGcircular;
	private JPanel panelGBarra;
	private JPanel panel_4;
	private JPanel pnlBarraVende;
	private JPanel pnlBarraProd;
	private String colorPlomo="#808793";
	private JLabel lblNewLabel;
	clsArial clsIcono=new clsArial();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntDashBoard frame = new IntDashBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntDashBoard() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				bcProductos();
				GbarraVentas();
				GbarraVendedorTop();
				GbarraProducStock();
				
			}
		});
	
		setBounds(100, 100, 1642, 901);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1626, 871);
		scrollPane.setBorder(null);
		getContentPane().add(scrollPane);
		
		panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setPreferredSize(new Dimension(1610,2000));
		panel_4.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_4);
		panel_4.setLayout(null);
		
		pnlBarraVende = new JPanel();
		pnlBarraVende.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlBarraVende.setBounds(81, 566, 699, 273);
		panel_4.add(pnlBarraVende);
		pnlBarraVende.setLayout(null);
		pnlBarraVende.setBorder(null);
		pnlBarraVende.setBackground(Color.WHITE);
		
		pnlGcircular = new JPanel();
		pnlGcircular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlGcircular.setBounds(1119, 194, 433, 319);
		panel_4.add(pnlGcircular);
		pnlGcircular.setLayout(null);
		pnlGcircular.setBorder(null);
		pnlGcircular.setBackground(Color.WHITE);
		
		panelGBarra = new JPanel();
		panelGBarra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGBarra.setBounds(81, 194, 914, 319);
		panel_4.add(panelGBarra);
		panelGBarra.setLayout(null);
		panelGBarra.setBorder(null);
		panelGBarra.setBackground(Color.decode("#ebf0f4"));
		
		pnlBarraProd = new JPanel();
		pnlBarraProd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlBarraProd.setBounds(861, 566, 699, 273);
		panel_4.add(pnlBarraProd);
		pnlBarraProd.setLayout(null);
		pnlBarraProd.setBorder(null);
		pnlBarraProd.setBackground(Color.WHITE);
		
		lblNewLabel = new JLabel("En Construccion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 42));
		lblNewLabel.setBounds(400, 902, 750, 212);
		panel_4.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IntFinanzas intFinanzas=new IntFinanzas();
				clsIcono.setInternalFrame(FrmMenuPrincipal.dktBody, intFinanzas,null,null);
			}
		});
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBackground(Color.decode("#3fdbbb"));
		panel.setBounds(81, 31, 302, 105);
		panel_4.add(panel);
		panel.setLayout(null);
		
		JLabel lblicoCobranza = new JLabel("");
		lblicoCobranza.setHorizontalAlignment(SwingConstants.CENTER);
		lblicoCobranza.setBounds(10, 38, 65, 50);
	
		clsIcono.modifiedIcon("/img/cobranza1.png", 45, 45,lblicoCobranza);
		panel.add(lblicoCobranza);
		
		JLabel label_1 = new JLabel("1555");
		label_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 31));
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(183, 38, 109, 44);
		panel.add(label_1);
		
		JLabel lblS = new JLabel("S./");
		lblS.setForeground(Color.WHITE);
		lblS.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblS.setHorizontalAlignment(SwingConstants.CENTER);
		lblS.setBounds(140, 38, 36, 44);
		panel.add(lblS);
		
		JLabel lblCobranza = new JLabel("Cobranza");
		lblCobranza.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblCobranza.setForeground(Color.WHITE);
		lblCobranza.setBounds(10, 11, 103, 14);
		panel.add(lblCobranza);
		
		JPanel panel_1 = new JPanel();
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setBackground(Color.decode("#f86c6b"));
		panel_1.setBounds(1250, 31, 302, 105);
		panel_4.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 38, 65, 50);
		
		clsIcono.modifiedIcon("/img/ganancia.png", 45, 45,label);
	
		panel_1.add(label);
		
		JLabel lblGanancia = new JLabel("Ganancia");
		lblGanancia.setForeground(Color.WHITE);
		lblGanancia.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblGanancia.setBounds(10, 11, 103, 14);
		panel_1.add(lblGanancia);
		
		JLabel label_1_2 = new JLabel("1555");
		label_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_2.setForeground(Color.WHITE);
		label_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 31));
		label_1_2.setBounds(183, 38, 109, 44);
		panel_1.add(label_1_2);
		
		JLabel lblS_2 = new JLabel("S./");
		lblS_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblS_2.setForeground(Color.WHITE);
		lblS_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblS_2.setBounds(140, 38, 36, 44);
		panel_1.add(lblS_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clsIcono.setInternalFrame(FrmMenuPrincipal.dktBody, new IntFinanzas(),IntFinanzas.dkFinanzas,new IntFinanza_pagos());
			
			}
		});
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.setBackground(Color.decode("#6ec2de"));
		panel_2.setBounds(478, 31, 302, 105);
		panel_4.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblicoPago = new JLabel("");
		lblicoPago.setHorizontalAlignment(SwingConstants.CENTER);
		lblicoPago.setBounds(10, 38, 65, 50);
	
		clsIcono.modifiedIcon("/img/pagos.png", 50, 50,lblicoPago);
		panel_2.add(lblicoPago);
		
		JLabel lblPago = new JLabel("Pago");
		lblPago.setForeground(Color.WHITE);
		lblPago.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblPago.setBounds(10, 11, 103, 21);
		panel_2.add(lblPago);
		
		JLabel label_1_1 = new JLabel("1555");
		label_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1_1.setForeground(Color.WHITE);
		label_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 31));
		label_1_1.setBounds(183, 38, 109, 44);
		panel_2.add(label_1_1);
		
		JLabel lblS_1 = new JLabel("S./");
		lblS_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblS_1.setForeground(Color.WHITE);
		lblS_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblS_1.setBounds(140, 38, 36, 44);
		panel_2.add(lblS_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.setBackground(Color.decode("#ffbe5e"));
		panel_3.setBounds(861, 31, 302, 105);
		
		panel_4.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblicoCantVenta = new JLabel("");
		lblicoCantVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblicoCantVenta.setBounds(10, 38, 65, 50);
	
		clsIcono.modifiedIcon("/img/carrito.png", 45, 45,lblicoCantVenta);
		panel_3.add(lblicoCantVenta);
		
		JLabel lblVentas = new JLabel("Venta");
		lblVentas.setForeground(Color.WHITE);
		lblVentas.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblVentas.setBounds(10, 11, 103, 14);
		panel_3.add(lblVentas);
		
		JLabel label_1_2_1 = new JLabel("24");
		label_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1_2_1.setForeground(Color.WHITE);
		label_1_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 31));
		label_1_2_1.setBounds(159, 38, 109, 44);
		panel_3.add(label_1_2_1);

	}

	
	
	void GbarraVentas() {
		
		int cant1=11400;
		int cant2=24000;
		int cant3=12100;
		int cant4=14200;
		int cant5=11200;
		int cant6=14110;
		int cant7=11000;
		
		
		DefaultCategoryDataset ds=new DefaultCategoryDataset();
		ds.addValue(cant6, "", "Enero");
		ds.addValue(cant7, "", "Febrero");
		ds.addValue(cant1, "", "Marzo");
		ds.addValue(cant2, "", "Abril");
		ds.addValue(cant3, "", "Mayo");
		ds.addValue(cant4, "", "Junio");
		ds.addValue(cant5, "", "Julio");
		
		JFreeChart jf=ChartFactory.createBarChart3D("Ventas por mes", "Meses"	, "Cantidad Vendida Por Mes", ds,PlotOrientation.VERTICAL,false,false,false);
		jf.getPlot().setBackgroundPaint(Color.decode("#ebf0f4"));
	

		TextTitle textTitle=jf.getTitle();
		
		textTitle.setFont(new Font("SANSSERIF",Font.BOLD,20));
		textTitle.setPaint(Color.DARK_GRAY);
	
		CategoryPlot plot=jf.getCategoryPlot();
		plot.setBackgroundAlpha(0);
		
		
	  
		plot.setRangeGridlinePaint(Color.GRAY);
		BarRenderer renderer=(BarRenderer)plot.getRenderer();

		renderer.setSeriesPaint(0, new Color(1, 50, 100));
		
		ChartPanel cPanel=new ChartPanel(jf);
        panelGBarra.setLayout(new BorderLayout());
		panelGBarra.add(cPanel,BorderLayout.CENTER);
		panelGBarra.validate();
		
		
	}
	
	void bcProductos() {
		
	
		
		DefaultPieDataset ds = new DefaultPieDataset();
		ds.setValue("panadol", 40);
		ds.setValue("cetirizina", 30);
		ds.setValue("ibuprofeno", 10);
		ds.setValue("paracetamol", 55);
		ds.setValue("nastiflu", 80);
	
		
		JFreeChart jf=ChartFactory.createPieChart3D("Productos mas Vendidos", ds,true,true,false);
	jf.setBorderVisible(false);
		jf.getPlot().setBackgroundPaint(Color.WHITE);
		TextTitle textTitle=jf.getTitle();
		textTitle.setFont(new Font("SANSSERIF",Font.BOLD,20));
		textTitle.setPaint(Color.DARK_GRAY);
		
		
		
		ChartPanel cPanel=new ChartPanel(jf);
		
        pnlGcircular.setLayout(new BorderLayout());
        pnlGcircular.add(cPanel);
        pnlGcircular.validate();
	}
	
	void GbarraVendedorTop() {
		
		int cant1=11400;
		int cant2=24000;
		int cant3=12100;
		int cant4=14200;
	
		
		
		DefaultCategoryDataset ds=new DefaultCategoryDataset();
		ds.addValue(cant1, "", "jorge");
		ds.addValue(cant2, "", "ernesto");
		ds.addValue(cant3, "", "alicia");
		ds.addValue(cant4, "", "arturo");
		
		
		JFreeChart jf=ChartFactory.createBarChart3D("Top Vendedores", "vendedores"	, "Cantidad Vendida Por Mes", ds,PlotOrientation.HORIZONTAL,false,false,false);
	
		CategoryPlot plot=jf.getCategoryPlot();
            plot.setBackgroundAlpha(0);
		
		
		plot.setRangeGridlinePaint(Color.GRAY);
		BarRenderer renderer=(BarRenderer)plot.getRenderer();
		renderer.setSeriesPaint(0,  new Color(1, 50, 100));
		
		TextTitle textTitle=jf.getTitle();
		textTitle.setFont(new Font("SANSSERIF",Font.BOLD,20));
		textTitle.setPaint(Color.DARK_GRAY);
		ChartPanel cPanel=new ChartPanel(jf);
        pnlBarraVende.setLayout(new BorderLayout());
        pnlBarraVende.add(cPanel,BorderLayout.CENTER);
        pnlBarraVende.validate();
		
	}
	
	void GbarraProducStock() {
		
		int cant1=320;
		int cant2=200;
		int cant3=100;
		int cant4=50;
	
		DefaultCategoryDataset ds=new DefaultCategoryDataset();
		ds.addValue(cant4, "", "panadol");
		ds.addValue(cant3, "", "ibuprofeno");
		ds.addValue(cant2, "", "nastizol");
		ds.addValue(cant1, "", "cetirizina");
	
		
		JFreeChart jf=ChartFactory.createBarChart3D("Stock Productos", "Prodcutos"	, "", ds,PlotOrientation.HORIZONTAL,false,false,false);
		TextTitle textTitle=jf.getTitle();
		textTitle.setFont(new Font("SANSSERIF",Font.BOLD,20));
		textTitle.setPaint(Color.DARK_GRAY);
		CategoryPlot plot=jf.getCategoryPlot();
plot.setBackgroundAlpha(0);
		
		
		plot.setRangeGridlinePaint(Color.GRAY);
		BarRenderer renderer=(BarRenderer)plot.getRenderer();
		renderer.setSeriesPaint(0,  new Color(1, 50, 100));
		
		ChartPanel cPanel=new ChartPanel(jf);
        pnlBarraProd.setLayout(new BorderLayout());
        pnlBarraProd.add(cPanel,BorderLayout.CENTER);
        pnlBarraProd.validate();
		
	}
}
