// Gourave Verma
// Computer Science Project: Vector Calculator (Related to Physics)
// This program calculates the sum of two vectors and tells the user the magnitude of the sum and the angle

  
   import java.awt.*; 
   import java.awt.event.*;
   import javax.swing.*;

   public class vectors extends JFrame implements ActionListener
   {
   	// Delclaring all the Variables and JComponents
      JPanel canvas = new JPanel(); 	 	
      JPanel pane = new JPanel();
   	
      JLabel magOne = new JLabel("Magnitude One:");
      JTextField magInputOne = new JTextField(5) ;
   	
      JLabel angleOne = new JLabel("Angle One:");
      JTextField angleInputOne = new JTextField(5) ; 
   	
      JLabel magTwo = new JLabel("Magnitude Two:");
      JTextField magInputTwo = new JTextField(5) ;
   	
      JLabel angleTwo = new JLabel("Angle Two:");
      JTextField angleInputTwo = new JTextField(5) ; 
   	
      JButton submit = new JButton("Submit");
      JButton exit = new JButton("Exit");
   	
      int magnitudeOne, magnitudeTwo, magnitudeThree, angOne, angTwo, angThree;
      double xOne, yOne, xTwo, yTwo;
   
      String selectedUnit = new String("");     	
      
      JComboBox units;
   	
      @SuppressWarnings("unchecked")		// Bypasses the warnings
														// If not used this will pop up:
														// Note: vectors.java uses unchecked or unsafe operations.
   													// Note: Recompile with -Xlint:unchecked for details.

      public vectors( String title )      // constructor
      {  
         super( title );
         setLayout( new BorderLayout() ); 
         
         pane.setLayout( new FlowLayout() );
      	
         String[] unit = {"units", "N", "Km", "m", "m/s" };   	
         units = new JComboBox(unit); 
      	
      	// Adding all the components to the JFrame
         add(canvas, BorderLayout.CENTER);
         add(pane, BorderLayout.SOUTH);
      	
         pane.add(magOne);    
         pane.add(magInputOne);
      
         pane.add(angleOne);      
         pane.add(angleInputOne);
      	
         pane.add(magTwo);    
         pane.add(magInputTwo);
      
         pane.add(angleTwo);      
         pane.add(angleInputTwo);
      	
         pane.add(units);
      	
         pane.add(submit);
         pane.add(exit);
      	
         magInputOne.addActionListener( this );
         angleInputOne.addActionListener( this );
         magInputTwo.addActionListener( this );
         angleInputTwo.addActionListener( this );
      	
      	// Initiates an action when a JButton is clicked  	   	      
         submit.addActionListener( this );  
         exit.addActionListener(this);   	
      	 
         setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
      }
   	   
      public void actionPerformed( ActionEvent evt)
      {
      	// Attempts the following code
         try {
            if (!magInputOne.getText().equals("")) {
               angleInputOne.requestFocus();
            
               if (!angleInputOne.getText().equals("")) {
               
                  magInputTwo.requestFocus();
               	
                  if (!magInputTwo.getText().equals("")) {
                     angleInputTwo.requestFocus();
                  
                     if (!angleInputTwo.getText().equals(""))
                        submit.requestFocus();            
                  
                  }
               }
            
            }     	
         	
            if  (evt.getActionCommand().equals( "Exit" )) {
               System.exit(0);
            }     	
            
            else if ( evt.getActionCommand().equals( "Submit" )) {
            	
            // Assigns the variables values that the user puts in
               magnitudeOne = Integer.parseInt(magInputOne.getText());
               magnitudeTwo = Integer.parseInt(magInputTwo.getText());
               angOne = Integer.parseInt(angleInputOne.getText());
               angTwo = Integer.parseInt(angleInputTwo.getText());
            
            // Assigns the variable 'selectedUnit' the unit that was selected by the user
               selectedUnit = (String)units.getSelectedItem();
            	
            // Finds the individual x and y components of each vector
               if (angOne >= 0 && angOne <= 360) {
                  xOne =((double)magnitudeOne * Math.cos(angOne * (Math.PI/180)));        
                  yOne =((double)magnitudeOne * Math.sin(angOne * (Math.PI/180)));
               }
               else 
                  JOptionPane.showMessageDialog(null, "Please enter an angle between 0-360"); 
            
               if (angTwo >= 0 && angOne <= 360) {
                  xTwo =((double)magnitudeTwo * Math.cos(angTwo * (Math.PI/180)));
                  yTwo =((double)magnitudeTwo * Math.sin(angTwo * (Math.PI/180)));
               }      
               else 
                  JOptionPane.showMessageDialog(null, "Please enter an angle between 0-360");
            
               JOptionPane.showMessageDialog(null, "The first vector will be in the color 'blue'\n\nThe second vector will be in the color 'green'\n\nThe third vector will be in the color 'red'");
            
            // Declaring the graphics for each seperate line and the color of each
               Graphics firstLine = canvas.getGraphics();
               Graphics secondLine = canvas.getGraphics();
               Graphics thirdLine = canvas.getGraphics();
            	
               firstLine.setColor(Color.blue);
               secondLine.setColor(Color.green);
               thirdLine.setColor(Color.red);
            
            // First if statement tests to see if both angles are over 0 and under 181	
               if (angOne >= 0 && angOne <= 180 && angTwo >= 0 && angTwo <= 180) {
               // First Vector
                  firstLine.drawLine(500, 400,(((int)xOne * -1) + 500), (int)yOne + 400);        
               
               // Second Vector
                  secondLine.drawLine(500, 400,(int)xTwo + 500, (((int)yTwo * -1) + 400));   
               
               // Last Vector
                  thirdLine.drawLine((((int)xOne * -1) + 500), (int)yOne + 400, (int)xTwo + 500, (((int)yTwo * -1) + 400));
               }
               
               // Second if statement tests to see if the first angle is over 180 and under 360
               // while the second one is over 0 and under 181
               else if (angOne >= 181 && angOne <= 360 && angTwo >= 0 && angTwo <= 180) {
               // First Vector
                  firstLine.drawLine(500, 400,((int)xOne + 500), (((int)yOne  * -1) + 400));        
               
               // Second Vector
                  secondLine.drawLine(500, 400,(int)xTwo + 500, (((int)yTwo * -1) + 400));   
               
               // Last Vector
                  thirdLine.drawLine(((int)xOne + 500), (((int)yOne * -1) + 400), (int)xTwo + 500, (((int)yTwo * -1) + 400));
               }
               
               // Third if statement tests to see if the second angle is over 180 and under 360
               // while the first angle is over 0 and under 181  
               else if (angOne >= 0 && angOne <= 180 && angTwo >= 181 && angTwo <= 360) {
               // First Vector
                  firstLine.drawLine(500, 400,((int)xOne + 500), (((int)yOne * -1) + 400));        
               
               // Second Vector 
                  secondLine.drawLine(((int)xOne + 500), (((int)yOne * -1) + 400),(int)xTwo + 500, (((int)yTwo * -1) + 400));   
               
               // Last Vector
                  thirdLine.drawLine((int)xTwo + 500, (((int)yTwo * -1) + 400), 500, 400);
               }
               
               // Fourth if statement tests to see if both angles are over 180 and under 360
               else if (angOne >= 181 && angOne <= 360 && angTwo >= 181 && angTwo <= 360) {
               // First Vector
                  firstLine.drawLine(500, 400,(((int)xOne * -1) + 500), (int)yOne + 400);        
               
               // Second Vector
                  secondLine.drawLine(500, 400,(int)xTwo + 500, (((int)yTwo * -1) + 400));   
               
               // Last Vector
                  thirdLine.drawLine((((int)xOne * -1) + 500), (int)yOne + 400, (int)xTwo + 500, (((int)yTwo * -1) + 400));
               }
            	
            // Finds the magnitude of the third Vector
               magnitudeThree = (int)(Math.sqrt(((xOne + xTwo) * (xOne + xTwo)) + ((yOne + yTwo) * (yOne + yTwo))));
            
            // Finds the angle of the third vector
               angThree = (int)((Math.atan2((yOne + yTwo), (xOne + xTwo))) * (180/Math.PI));
            	
            // Tests to see if angThree is a negative angle
            // If it is negative, it will make it positive e.g. -90 degrees = 270 degrees
               if (angThree < 0)
                  angThree = 360 + angThree;
            		
            	
            // Displays information about the third vector such as the magnitude, angle and units
               final JOptionPane message = new JOptionPane("When both vectors are added the magnitude is " + magnitudeThree + " " + selectedUnit + " and the angle is " + angThree + "\n\n                                   If you click 'OK', the image will go away!");
               final JDialog messageBox = message.createDialog((JFrame)null, "Calculations");
               messageBox.setLocation(0,0);
               messageBox.setVisible(true);
            	           
            // After the pop-up all fields will be set to default except for the units
               magInputOne.setText("");
               angleInputOne.setText("");
               magInputTwo.setText("");
               angleInputTwo.setText("");
            	
               magInputOne.requestFocus();
               
               repaint();
            }
         
         }
         	
         	// Catches any and all errors
            catch(Exception e) {
               JOptionPane.showMessageDialog(null, "Please enter valid Coordinates!");
            }
      }
   
      public static void main ( String[] args )
      {
         vectors vector  = new vectors( "Vector Calculator by Gourave Verma" ) ;  
         vector.setExtendedState(Frame.MAXIMIZED_BOTH);	// Makes the frame full screen
         vector.setUndecorated(true);						 	// Eliminates the border at the top for a full screen experience
         vector.setLocationRelativeTo( null );   			// Positions the frame to the centre of the screen
         vector.setVisible( true );      
      }
   }