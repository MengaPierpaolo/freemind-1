package tests.freemind;

import java.awt.Color;
import java.awt.Component;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.event.TreeModelListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import freemind.controller.Controller;
import freemind.controller.MapModuleManager;
import freemind.controller.StructuredMenuHolder;
import freemind.controller.filter.Filter;
import freemind.extensions.HookFactory;
import freemind.main.FreeMindMain;
import freemind.main.XMLParseException;
import freemind.modes.MapAdapter;
import freemind.modes.MapRegistry;
import freemind.modes.MindMap;
import freemind.modes.MindMapLinkRegistry;
import freemind.modes.MindMapNode;
import freemind.modes.Mode;
import freemind.modes.ModeController;
import freemind.modes.NodeAdapter;
import freemind.modes.MindMap.MapSourceChangedObserver;
import freemind.modes.ModeController.NodeLifetimeListener;
import freemind.modes.ModeController.NodeSelectionListener;
import freemind.modes.attributes.AttributeController;
import freemind.modes.attributes.AttributeRegistry;
import freemind.view.MapModule;
import freemind.view.mindmapview.MapView;
import freemind.view.mindmapview.NodeView;

public class AttributeRegistryIntegrationTest extends FreeMindTestBase {

	private AttributeRegistry sut;
	
	@Override
	public void setUp() {
		MindMap map = new MindMap() {
			
			@Override
			public void valueForPathChanged(TreePath path, Object newValue) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeTreeModelListener(TreeModelListener l) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isLeaf(Object node) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Object getRoot() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getIndexOfChild(Object parent, Object child) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getChildCount(Object parent) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getChild(Object parent, int index) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addTreeModelListener(TreeModelListener l) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setSaved(boolean isSaved) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFilter(Filter inactiveFilter) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean save(File file) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void registerMapSourceChangedObserver(
					MapSourceChangedObserver pMapSourceChangedObserver,
					long pGetEventIfChangedAfterThisTimeInMillies) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void nodeStructureChanged(TreeNode node) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void nodeRefresh(TreeNode node) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void nodeChanged(TreeNode node) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void load(URL file) throws FileNotFoundException, IOException,
					XMLParseException, URISyntaxException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isSaved() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isReadOnly() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void getXml(Writer fileout) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public URL getURL() throws MalformedURLException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MindMapNode getRootNode() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getRestorable() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MapRegistry getRegistry() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public TreeNode[] getPathToRoot(TreeNode node) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ModeController getModeController() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MindMapLinkRegistry getLinkRegistry() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void getFilteredXml(Writer fileout) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Filter getFilter() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public File getFile() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getAsRTF(List mindMapNodes) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getAsPlainText(List mindMapNodes) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getAsHTML(List mindMapNodes) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void destroy() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public long deregisterMapSourceChangedObserver(
					MapSourceChangedObserver pMapSourceChangedObserver) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void changeRoot(MindMapNode newRoot) {
				// TODO Auto-generated method stub
				
			}
		};
		
		ModeController controller = new ModeController() {
			
			@Override
			public void updatePopupMenu(StructuredMenuHolder holder) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void updateMenus(StructuredMenuHolder holder) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void startupController() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sortNodesByDepth(List inPlaceList) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void shutdownController() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void showPopupMenu(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setVisible(boolean visible) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setView(MapView pView) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setModel(MapAdapter model) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setLastCurrentDir(File pLastCurrentDir) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFolded(MindMapNode node, boolean folded) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void selectBranch(NodeView selected, boolean extend) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void select(MindMapNode focused, List selecteds) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void select(NodeView node) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean saveAs() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean save() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean save(File file) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void registerNodeSelectionListener(NodeSelectionListener listener,
					boolean pCallWithCurrentSelection) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void registerNodeLifetimeListener(NodeLifetimeListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void refreshMap() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void plainClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void open() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onViewRemovedHook(NodeView newView) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onViewCreatedHook(NodeView newView) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLostFocusNode(NodeView node) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFocusNode(NodeView node) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void nodeRefresh(MindMapNode node) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void nodeChanged(MindMapNode n) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public MindMap newMap() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void loadURL(String relative) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public ModeController load(File file) throws FileNotFoundException,
					IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ModeController load(URL file) throws FileNotFoundException,
					IOException, XMLParseException, URISyntaxException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isBlocked() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public MapView getView() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getText(String textId) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getSelectionColor() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List getSelectedsByDepth() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List getSelecteds() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public NodeView getSelectedView() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MindMapNode getSelected() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public URL getResource(String path) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JPopupMenu getPopupMenu() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JPopupMenu getPopupForModel(Object obj) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public NodeView getNodeView(MindMapNode node) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getNodeID(MindMapNode selected) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public NodeAdapter getNodeFromID(String nodeID) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JToolBar getModeToolBar() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Mode getMode() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MapModule getMapModule() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MindMap getMap() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getLinkShortText(MindMapNode node) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Component getLeftToolBar() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public File getLastCurrentDir() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public HookFactory getHookFactory() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FreeMindMain getFrame() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public JFileChooser getFileChooser(FileFilter filter) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Controller getController() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public AttributeController getAttributeController() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void firePreSaveEvent(MindMapNode node) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fireNodePreDeleteEvent(MindMapNode node) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean extendSelection(MouseEvent e) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void doubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void displayNode(MindMapNode node) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void deregisterNodeSelectionListener(NodeSelectionListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void deregisterNodeLifetimeListener(NodeLifetimeListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public MindMapNode createNodeTreeFromXml(Reader pReader, HashMap pIDToTarget)
					throws XMLParseException, IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Transferable copySingle() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Transferable copy(List selectedNodes, boolean copyInvisible) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Transferable copy() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Transferable copy(MindMapNode node, boolean saveInvisible) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean close(boolean force, MapModuleManager mapModuleManager) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void changeSelection(NodeView pNode, boolean pIsSelected) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void centerNode(MindMapNode node) {
				// TODO Auto-generated method stub
				
			}
		};
		
		MapRegistry registry = new MapRegistry(map, controller);
		sut = new AttributeRegistry(registry);
	}
	
	public void testGettingInitialKeyShouldNotBeNull() {
		assertNotNull(sut.getKey(0));
	}	
	
}
