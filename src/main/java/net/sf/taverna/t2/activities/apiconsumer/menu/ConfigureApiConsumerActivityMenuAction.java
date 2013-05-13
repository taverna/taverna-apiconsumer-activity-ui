/**
 *
 */
package net.sf.taverna.t2.activities.apiconsumer.menu;

import java.net.URI;

import javax.swing.Action;

import net.sf.taverna.t2.activities.apiconsumer.ApiConsumerActivity;
import net.sf.taverna.t2.activities.apiconsumer.actions.ApiConsumerActivityConfigurationAction;
import net.sf.taverna.t2.servicedescriptions.ServiceDescriptionRegistry;
import net.sf.taverna.t2.workbench.activityicons.ActivityIconManager;
import net.sf.taverna.t2.workbench.activitytools.AbstractConfigureActivityMenuAction;
import net.sf.taverna.t2.workbench.edits.EditManager;
import net.sf.taverna.t2.workbench.file.FileManager;

/**
 * @author alanrw
 *
 */
public class ConfigureApiConsumerActivityMenuAction extends AbstractConfigureActivityMenuAction {

	private static final URI ACTIVITY_TYPE = URI.create("http://ns.taverna.org.uk/2010/activity/apiconsumer");

	private EditManager editManager;
	private FileManager fileManager;
	private ActivityIconManager activityIconManager;
	private ServiceDescriptionRegistry serviceDescriptionRegistry;

	public ConfigureApiConsumerActivityMenuAction() {
		super(ACTIVITY_TYPE);
	}

	@Override
	protected Action createAction() {
		ApiConsumerActivityConfigurationAction configAction = new ApiConsumerActivityConfigurationAction(
				findActivity(), getParentFrame(), editManager, fileManager, activityIconManager, serviceDescriptionRegistry);
		configAction.putValue(Action.NAME, ApiConsumerActivityConfigurationAction.CONFIGURE_APICONSUMER_ACTIVITY);
		addMenuDots(configAction);
		return configAction;
	}

	public void setEditManager(EditManager editManager) {
		this.editManager = editManager;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public void setActivityIconManager(ActivityIconManager activityIconManager) {
		this.activityIconManager = activityIconManager;
	}

	public void setServiceDescriptionRegistry(ServiceDescriptionRegistry serviceDescriptionRegistry) {
		this.serviceDescriptionRegistry = serviceDescriptionRegistry;
	}

}
