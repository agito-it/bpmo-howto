package com.sample.bpmo;


import de.agito.cps.core.bpmo.ControlType;
import de.agito.cps.core.bpmo.DataTypeFactory;
import de.agito.cps.core.bpmo.IEnumInspector;
import de.agito.cps.core.bpmo.api.enums.IBODataElement;
import de.agito.cps.core.bpmo.api.enums.IBOId;
import de.agito.cps.core.bpmo.api.enums.IBONode;


/**
 * Enum for HelloWorldBPMO.
 *
 * @author andreas.weise
 */
public enum HelloWorldBPMO implements IBODataElement {

	;
	/**
	 * <b>BPMO Identifier</b>
	 */
	public final static IBOId $BPMO = new IBOId.BOId("HelloWorldBPMO");

	/**
	 * <b>Node Identifier</b>
	 */
	public final static IBONode $ID = new IBONode.BONode("HelloWorldBPMO", "HelloWorldBPMO", ControlType.DEFAULT);

	private final static IEnumInspector ENUM_INSPECTOR = DataTypeFactory.getInstance().createEnumInspector(HelloWorldBPMO.class);
	private HelloWorldBPMO(String id, String path, ControlType controlType) { this.id = id; this.path = path; this.controlType = controlType; }
	private String id;
	public String getId() { return id; }
	private String path;
	public String getPath() { return path; }
	private ControlType controlType;
	public ControlType getControlType() { return controlType; }

	/**
	 * Retrieve a content element for a given path.
	 * 
	 * @return
	 *             Element requested or {@link IEnumInspector}.UNDEFINED_DATA if element does not exist. 
	 * @throws ClassCastException
	 *             when the corresponding element for given path is not a content element.
	 */
	public static IBODataElement getIBODataElementByPath(String path) throws ClassCastException { return ENUM_INSPECTOR.getIBODataElementByPath(path); }

	/**
	 * Retrieve a node for a given path.
	 * 
	 * @return
	 *             Node requested or {@link IEnumInspector}.UNDEFINED_NODE if node does not exist. 
	 * @throws ClassCastException
	 *             when the corresponding element for given path is not a node.
	 */ 
	public static IBONode getIBONodeByPath(String path) throws ClassCastException { return ENUM_INSPECTOR.getIBONodeByPath(path); }

}

