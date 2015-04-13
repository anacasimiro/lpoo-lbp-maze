package maze.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import maze.logic.DragonType;
import maze.logic.Settings;

/**
 * A class that represents the settings dialog
 * 
 * @author Ana Casimiro
 * @author Joao Bernardino
 *
 */
public class SettingsDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

	protected Settings mazeSettings;
	
	protected JPanel panel;
	
	protected JLabel mazeDimensionLabel;
	protected JLabel numberOfDragonsLabel;
	protected JLabel numberOfSwordsLabel;
	protected JLabel numberOfShieldsLabel;
	protected JLabel dragonsTypeLabel;
	
	protected JSpinner mazeDimensionSpinner;
	protected JSpinner numberOfDragonsSpinner;
	protected JSpinner numberOfSwordsSpinner;
	protected JSpinner numberOfShieldsSpinner;
	protected JSpinner dragonsTypeSpinner;
	protected JComboBox<DragonType> dragonsTypeComboBox;
	
	protected JButton saveButton;
	protected JButton cancelButton;
	
	
	/**
	 * Creates a new instance of the class
	 *
	 */
	public SettingsDialog(Settings mazeSettings) {
		
		this.mazeSettings = mazeSettings;
		
		panel = new JPanel( new GridLayout(6, 2, 5, 8) );
		panel.setBorder( new EmptyBorder(30, 60, 30, 60) );
		
		setContentPane( panel );
		
		createWidgets();
		addWidgets();
	
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if ( e.getKeyCode() == KeyEvent.VK_ESCAPE ) {
					dispose();
				}
				
			}
			
		});
		
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setFocusable(true);
		setModal(true);
		
		setVisible(true);
		
	}
	
	
	/**
	 * Creates all necessary widgets
	 * 
	 */
	protected void createWidgets() {
	
		
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
		
		
		// Dragons Type
		
		dragonsTypeLabel = new JLabel("Dragons type:");
		dragonsTypeComboBox = new JComboBox<DragonType>(DragonType.values());
		dragonsTypeComboBox.setSelectedItem( mazeSettings.getDragonsType() );	
		
		
		// Save Button
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				mazeSettings.setMazeDimension( (Integer)mazeDimensionSpinner.getValue() );
				mazeSettings.setNumberOfDragons( (Integer)numberOfDragonsSpinner.getValue() );
				mazeSettings.setNumberOfSwords( (Integer)numberOfSwordsSpinner.getValue() );
				mazeSettings.setNumberOfShields( (Integer)numberOfShieldsSpinner.getValue() );
				mazeSettings.setDragonsType( (DragonType)dragonsTypeComboBox.getSelectedItem() );
				
				dispose();
				
			}
			
		});
		
		
		// Cancel Button
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
	
		
	}
	
	
	/**
	 * Adds all the widgets to the JPanel
	 * 
	 */
	protected void addWidgets() {
		
		panel.add(mazeDimensionLabel);
		panel.add(mazeDimensionSpinner);
		
		panel.add(numberOfDragonsLabel);
		panel.add(numberOfDragonsSpinner);
		
		panel.add(numberOfSwordsLabel);
		panel.add(numberOfSwordsSpinner);
		
		panel.add(numberOfShieldsLabel);
		panel.add(numberOfShieldsSpinner);
		
		panel.add(dragonsTypeLabel);
		panel.add(dragonsTypeComboBox);
		
		panel.add(saveButton);
		panel.add(cancelButton);
		
	}
	
	
}
