package photoAlbum;

import java.awt.*;
import java.awt.Image;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frame;
	static JLabel[] label = new JLabel [11]; 
	static JLabel[] title = new JLabel [11];
	JButton btnNewButton;
	
	static ArrayList <Photo> photos = new ArrayList <Photo>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		reconstruct();
		frame = new JFrame("Digital Photo Album");
		frame.setBounds(100, 100, 758, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		for(int i=1;i<=10;i++)
		{
			label[i] = new JLabel("No Image");
			label[i].setHorizontalAlignment(SwingConstants.CENTER);
			if(i<=photos.size())
			label[i].setToolTipText("" + photos.get(i-1).annotation);
		}


		label[1].setBounds(40, 60, 120, 90);
		frame.getContentPane().add(label[1]);
		label[1].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       if(label[1].getText().equals("No Image")) return;
		       NewPhoto photo = new NewPhoto(photos.get(0).src,2);
		       photo.setVisible(true);
		    }  
		}); 
		
		
		label[2].setBounds(188, 60, 120, 90);
		frame.getContentPane().add(label[2]);
		label[2].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(label[2].getText().equals("No Image")) return;
		        NewPhoto photo = new NewPhoto(photos.get(1).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		label[3].setBounds(337, 60, 120, 90);
		frame.getContentPane().add(label[3]);
		label[3].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(label[3].getText().equals("No Image")) return;
		        NewPhoto photo = new NewPhoto(photos.get(2).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		label[4].setBounds(476, 60, 120, 90);
		frame.getContentPane().add(label[4]);
		label[4].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(label[4].getText().equals("No Image")) return;
		        NewPhoto photo = new NewPhoto(photos.get(3).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		label[5].setBounds(609, 60, 120, 90);
		frame.getContentPane().add(label[5]);
		label[5].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(label[5].getText().equals("No Image")) return;
		        NewPhoto photo = new NewPhoto(photos.get(4).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		label[6].setBounds(40, 190, 120, 90);
		frame.getContentPane().add(label[6]);
		label[6].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(label[6].getText().equals("No Image")) return;
		        NewPhoto photo = new NewPhoto(photos.get(5).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		
		label[7].setBounds(188, 190, 120, 90);
		frame.getContentPane().add(label[7]);
		label[7].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(label[7].getText().equals("No Image")) return;
		        NewPhoto photo = new NewPhoto(photos.get(6).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		label[8].setBounds(337, 190, 120, 90);
		frame.getContentPane().add(label[8]);
		label[8].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(label[8].getText().equals("No Image")) return;
		        NewPhoto photo = new NewPhoto(photos.get(7).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		label[9].setBounds(476, 190, 120, 90);
		frame.getContentPane().add(label[9]);
		label[9].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(label[9].getText().equals("No Image")) return;
		        NewPhoto photo = new NewPhoto(photos.get(8).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		
		label[10].setBounds(609, 190, 120, 90);
		frame.getContentPane().add(label[10]);
		label[10].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(label[10].getText().equals("No Image")) return;
		        NewPhoto photo = new NewPhoto(photos.get(9).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		
		
		title[1] = new JLabel("");
		title[1].setBounds(40, 151, 100, 19);
		frame.getContentPane().add(title[1]);
		title[1].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       if(title[1].getText().equals("")) return;
		       NewPhoto photo = new NewPhoto(photos.get(0).src,2);
		       photo.setVisible(true);
		    }  
		}); 
		
		title[2] = new JLabel("");
		title[2].setBounds(188, 151, 100, 19);
		frame.getContentPane().add(title[2]);
		title[2].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(title[2].getText().equals("")) return;
		        NewPhoto photo = new NewPhoto(photos.get(1).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		title[3] = new JLabel("");
		title[3].setBounds(337, 151, 100, 19);
		frame.getContentPane().add(title[3]);
		title[3].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(title[3].getText().equals("")) return;
		        NewPhoto photo = new NewPhoto(photos.get(2).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		title[4] = new JLabel("");
		title[4].setBounds(476, 151, 100, 19);
		frame.getContentPane().add(title[4]);
		title[4].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(title[4].getText().equals("")) return;
		        NewPhoto photo = new NewPhoto(photos.get(3).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		title[5] = new JLabel("");
		title[5].setBounds(609, 151, 100, 19);
		frame.getContentPane().add(title[5]);
		title[5].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(title[5].getText().equals("")) return;
		        NewPhoto photo = new NewPhoto(photos.get(4).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		title[6] = new JLabel("");
		title[6].setBounds(40, 279, 100, 19);
		frame.getContentPane().add(title[6]);
		title[6].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(title[6].getText().equals("")) return;
		        NewPhoto photo = new NewPhoto(photos.get(5).src,2);
		        photo.setVisible(true);
		    }  
		});
		
		title[7] = new JLabel("");
		title[7].setBounds(188, 279, 100, 19);
		frame.getContentPane().add(title[7]);
		title[7].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(title[7].getText().equals("")) return;
		        NewPhoto photo = new NewPhoto(photos.get(6).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		title[8] = new JLabel("");
		title[8].setBounds(337, 279, 100, 19);
		frame.getContentPane().add(title[8]);
		title[8].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(title[8].getText().equals("")) return;
		        NewPhoto photo = new NewPhoto(photos.get(7).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		title[9] = new JLabel("");
		title[9].setBounds(476, 279, 100, 19);
		frame.getContentPane().add(title[9]);
		title[9].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(title[9].getText().equals("")) return;
		        NewPhoto photo = new NewPhoto(photos.get(8).src,2);
		        photo.setVisible(true);
		    }  
		}); 
		
		title[10] = new JLabel("");
		title[10].setBounds(609, 279, 100, 19);
		frame.getContentPane().add(title[10]);
		title[10].addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(title[10].getText().equals("")) return;
		        NewPhoto photo = new NewPhoto(photos.get(9).src,2);
		        photo.setVisible(true);
		    }  
		}); 
	
		btnNewButton = new JButton("Add New Image");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
				JFileChooser jfc = new JFileChooser();
				jfc.setFileFilter(filter);
				if(jfc.showOpenDialog(btnNewButton) == JFileChooser.APPROVE_OPTION)
				{
					if(photos.size()>=10)
					{
						JOptionPane.showMessageDialog(null, "Limit Reached","The Current implementation supports upto 10 images.",JOptionPane.ERROR_MESSAGE);
					}
					java.io.File f = jfc.getSelectedFile();
					NewPhoto photo = new NewPhoto(f.toString(),1);
					photo.setVisible(true);
					
				//	Photo photo = new Photo();
				//	photo.src = f.toString();
				//	photos.add(photo);
					//image.add(new Image());
					
				//	SetImageSize(label[photos.size()],f.toString());
					
				//	label[1].setHorizontalAlignment(label[1].CENTER);
					
					
				}
			}
		});
		
		
		JLabel label_11 = new JLabel("");
		label_11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(photos.size()<1) return;
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this photo?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(n==0){
				photos.remove(0);
				update();}
			}
		});
		label_11.setBounds(145, 151, 16, 14);
		frame.getContentPane().add(label_11);
		SetImageSizeBin(label_11,"/remove.png");
		
		
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(293, 151, 16, 14);
		frame.getContentPane().add(label_12);
		SetImageSizeBin(label_12,"/remove.png");
		label_12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(photos.size()<2) return;
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this photo?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(n==0){
				photos.remove(1);
				update();}
			}
		});
		
		
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(441, 151, 16, 14);
		frame.getContentPane().add(label_13);
		SetImageSizeBin(label_13,"/remove.png");
		label_13.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(photos.size()<3) return;
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this photo?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(n==0){
				photos.remove(2);
				update();}
			}
		});
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(581, 151, 16, 14);
		frame.getContentPane().add(label_14);
		SetImageSizeBin(label_14,"/remove.png");
		label_14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(photos.size()<4) return;
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this photo?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(n==0){
				photos.remove(3);
				update();}
			}
		});
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(714, 151, 16, 14);
		frame.getContentPane().add(label_15);
		SetImageSizeBin(label_15,"/remove.png");
		label_15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(photos.size()<5) return;
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this photo?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(n==0){
				photos.remove(4);
				update();}
			}
		});
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(145, 282, 16, 14);
		frame.getContentPane().add(label_16);
		SetImageSizeBin(label_16,"/remove.png");
		label_16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(photos.size()<6) return;
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this photo?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(n==0){
				photos.remove(5);
				update();}
			}
		});
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(293, 282, 16, 14);
		frame.getContentPane().add(label_17);
		SetImageSizeBin(label_17,"/remove.png");
		label_17.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(photos.size()<7) return;
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this photo?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(n==0){
				photos.remove(6);
				update();}
			}
		});
		
		JLabel label_18 = new JLabel("");
		label_18.setBounds(441, 282, 16, 14);
		frame.getContentPane().add(label_18);
		SetImageSizeBin(label_18,"/remove.png");
		label_18.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(photos.size()<8) return;
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this photo?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(n==0){
				photos.remove(7);
				update();}
			}
		});
		
		JLabel label_19 = new JLabel("");
		label_19.setBounds(581, 282, 16, 14);
		frame.getContentPane().add(label_19);
		SetImageSizeBin(label_19,"/remove.png");
		label_19.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(photos.size()<9) return;
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this photo?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(n==0){
				photos.remove(8);
				update();}
			}
		});
		
		JLabel label_20 = new JLabel("");
		label_20.setBounds(714, 282, 16, 14);
		frame.getContentPane().add(label_20);
		SetImageSizeBin(label_20,"/remove.png");
		label_11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(photos.size()<10) return;
				int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this photo?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(n==0){
				photos.remove(9);
				update();}
			}
		});
		
		
		
		JLabel lblWelcomeToYour = new JLabel("WELCOME TO YOUR PHOTO ALBUM");
		lblWelcomeToYour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblWelcomeToYour.setForeground(Color.WHITE);
		lblWelcomeToYour.setBounds(37, 11, 392, 32);
		frame.getContentPane().add(lblWelcomeToYour);
		btnNewButton.setBounds(562, 19, 147, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel bckgd = new JLabel("");
		bckgd.setBounds(0, 0, 745, 367);
		frame.getContentPane().add(bckgd);
		SetImageSizeBin(bckgd,"/background.png");
		
		update();
	}
	
	public static void SetImageSize(JLabel label,String imgName)
	{ 
		ImageIcon icon = new ImageIcon(imgName); 
		Image img = icon.getImage(); 
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon newImc = new ImageIcon(newImg); 
		label.setIcon(newImc); 
	}
	
	public void SetImageSizeBin(JLabel label,String imgName)
	{ 
		ImageIcon icon = new ImageIcon(this.getClass().getResource(imgName)); 
		Image img = icon.getImage(); 
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon newImc = new ImageIcon(newImg); 
		label.setIcon(newImc); 
	}
	
	
	public static void save()
	{
		String fileName = "data.txt";
		try{PrintWriter pw = new PrintWriter(fileName); pw.close();}
		catch(Exception e){System.out.println("Error! File " + fileName + " not found!");}
		for(int i=0;i<photos.size();i++)
		{
			FileWriter fileWriter = null;
			try {fileWriter = new FileWriter(fileName,true);} 
			catch (IOException ex) {System.out.println("Error writing to file '"+ fileName + "'");}
			try(BufferedWriter bufferedWriter= new BufferedWriter(fileWriter))
			{
				bufferedWriter.write("NEW PHOTO"); bufferedWriter.newLine();
				bufferedWriter.write("SRC"); bufferedWriter.newLine();
				bufferedWriter.write("" + photos.get(i).src); bufferedWriter.newLine();
				bufferedWriter.write("TITLE"); bufferedWriter.newLine();
				bufferedWriter.write("" + photos.get(i).title); bufferedWriter.newLine();
				bufferedWriter.write("ANNOTATION"); bufferedWriter.newLine();
				bufferedWriter.write("" + photos.get(i).annotation); bufferedWriter.newLine();
				bufferedWriter.write("xx- END OF PHOTO -xx"); bufferedWriter.newLine();
			}
			catch(IOException e){System.out.println("Exception! Error writing to file "+ fileName);}
		}
	
	}
	public static void reconstruct()
	{
		String s = null;
		Photo photo = null;
		String fileName = "data.txt";
		FileReader fileReader = null;
        try {fileReader = new FileReader(fileName);} catch (FileNotFoundException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
            try (BufferedReader bufferedReader = new BufferedReader(fileReader))
            {
            	while((s=bufferedReader.readLine())!=null)
            	{
            		if(s.equals("NEW PHOTO"))
            		{
            			photo = new Photo();
            		}
            		else if(s.equals("SRC"))
            		{
            			s=bufferedReader.readLine();
            			photo.src = s;
            		}
            		else if(s.equals("TITLE"))
            		{
            			s=bufferedReader.readLine();
            			photo.title = s;
            		}
            		else if(s.equals("ANNOTATION"))
            		{
            			s=bufferedReader.readLine();
            			photo.annotation = s;
            		}
            		else if(s.equals("xx- END OF PHOTO -xx"))
            		{
            			photos.add(photo);
            		}
            	}
            }
            catch(IOException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
	}
	
	public static void update()
	{
		for(int i=0;i<photos.size();i++)
		{
			SetImageSize(label[i+1],photos.get(i).src);
			label[i+1].setText("");
			title[i+1].setText(photos.get(i).title);
		}
		/*
		 * Moving save() from for loop to outside of it to improve efficiency and 
		 * remove bug that prevented update of info in data.txt upon last remaining 
		 * image deletion  
		 */
		save();
		for(int i=photos.size();i<10;i++)
		{
			SetImageSize(label[i+1],null);
			label[i+1].setText("No Image");
			title[i+1].setText("");
		}
		updateToolTip();
	}
	public static void updateToolTip()
	{
		for(int i=1;i<=photos.size();i++)
		{
			label[i].setToolTipText("" + photos.get(i-1).annotation);
		}
		
		for(int i=photos.size()+1;i<=10;i++)
		{
			label[i].setToolTipText("");
		}
	}
}
