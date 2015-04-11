package maze.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import maze.logic.Settings;

/**
 * A class that represents the settings panel
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class SettingsPanel extends JPanel {
	
	Settings mazeSettings;
	
	JLabel mazeDimensionLabel;
	JLabel numberOfDragonsLabel;
	JLabel numberOfSwordsLabel;
	JLabel numberOfShieldsLabel;
	JLabel dragonsTypeLabel;
	
	JSpinner mazeDimensionSpinner;
	JSpinner numberOfDragonsSpinner;
	JSpinner numberOfSwordsSpinner;
	JSpinner numberOfShieldsSpinner;
	JSpinner dragonsTypeSpinner;
	
	JButton saveButton;
	JButton cancelButton;
	
	
	/**
	 * Creates all necessary widgets
	 * 
	 */
	private void createWidgets() {
	
		
		// Maze Dimension
		
		mazeDimensionLabel = new JLabel("Maze Dimension:");
		mazeDimensionSpinner = new JSpinner( new SpinnerNumberModel(7, 7, 31, 2) );
		DefaultEditor mazeDimensionTextField = (DefaultEditor)mazeDimensionSpinner.getEditor();
		mazeDimensionTextField.getTextField().setEditable(false);
		mazeDimensionSpinner.setValue( mazeSettings.getMazeDimension() );
		
		
		// Number of Dragons
		
		numberOfDragonsLabel = new JLabel("Number of dragons:");
		numberOfDragonsSpinner = new JSpinner( new SpinnerNumberModel(1, 1, 10, 1) );
		DefaultEditor numberOfDragonsTextField = (DefaultEditor)numberOfDragonsSpinner.getEditor();
		numberOfDragonsTextField.getTextField().setEditable(false);
		numberOfDragonsSpinner.setValue( mazeSettings.getNumberOfDragons() );
		
		
		// Number of Swords
		
		numberOfSwordsLabel = new JLabel("Number of swords:");
		numberOfSwordsSpinner = new JSpinner( new SpinnerNumberModel(1, 1, 10, 1) );
		DefaultEditor numberOfSwordsTextField = (DefaultEditor)numberOfSwordsSpinner.getEditor();
		numberOfSwordsTextField.getTextField().setEditable(false);
		numberOfSwordsSpinner.setValue( mazeSettings.getNumberOfSwords() );
		
		
		// Number of Shields
		
		numberOfShieldsLabel = new JLabel("Number of shields:");
		numberOfShieldsSpinner = new JSpinner( new SpinnerNumberModel(1, 1, 10, 1) );
		DefaultEditor numberOfShieldsTextField = (DefaultEditor)numberOfShieldsSpinner.getEditor();
		numberOfShieldsTextField.getTextField().setEditable(false);
		numberOfShieldsSpinner.setValue( mazeSettings.getNumberOfShields() );
		
		
		// Save Button
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				mazeSettings.setMazeDimension( (Integer)mazeDimensionSpinner.getValue() );
				mazeSettings.setNumberOfDragons( (Integer)numberOfDragonsSpinner.getValue() );
				mazeSettings.setNumberOfSwords( (Integer)numberOfSwordsSpinner.getValue() );
				mazeSettings.setNumberOfShields( (Integer)numberOfShieldsSpinner.getValue() );
				
				Launcher.showMainMenu();
				
			}
			
		});
		
		
		// Cancel Button
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Launcher.showMainMenu();
			}
			
		});
	
		
	}
	
	
	
	/**
	 * Adds all the widgets to the JPanel
	 * 
	 */
	private void addWidgets() {
		
		this.add(mazeDimensionLabel);
		this.add(mazeDimensionSpinner);
		
		this.add(numberOfDragonsLabel);
		this.add(numberOfDragonsSpinner);
		
		this.add(numberOfSwordsLabel);
		this.add(numberOfSwordsSpinner);
		
		this.add(numberOfShieldsLabel);
		this.add(numberOfShieldsSpinner);
		
		this.add(saveButton);
		this.add(cancelButton);
		
	}
	
	
	/**
	 * Creates a new instance of the class
	 *
	 */
	public SettingsPanel(Settings mazeSettings) {
		
		this.mazeSettings = mazeSettings;
		
		//this.setPreferredSize( new Dimension(400, 700) );
		this.setBorder( new EmptyBorder(30, 60, 30, 60) );
		this.setLayout( new GridLayout(5, 2) );
		
		createWidgets();
		addWidgets();
		
		
	}
	
}
