package com.usfoods.bamboo.spec.plan;

import java.util.Arrays;
import java.util.List;
import com.atlassian.bamboo.specs.api.BambooSpec;
import com.atlassian.bamboo.specs.api.builders.deployment.Deployment;
import com.atlassian.bamboo.specs.api.builders.permission.DeploymentPermissions;
import com.atlassian.bamboo.specs.api.builders.permission.EnvironmentPermissions;
import com.atlassian.bamboo.specs.util.BambooServer;
import com.usfoods.bamboo.spec.standard.pipeline.StandardMulesoftDeploymentPlanSpec;

@BambooSpec
public class MulesoftDeploymentPlanSpec extends StandardMulesoftDeploymentPlanSpec
{


	public static String PROPERTY_NAME = "pim-product-prc-api-mulesoft-project.properties";

	public static void main(String... argv) {
	      //By default credentials are read from the '.credentials' file.
		  setProperty(PROPERTY_NAME);
		  init();
		  BambooServer bambooServer = new BambooServer(projectProp.getBambooHostname());
		  final MulesoftDeploymentPlanSpec planSpec = new MulesoftDeploymentPlanSpec();

			List<Deployment> deployList = planSpec.rootObject();
			for (Deployment deployStr : deployList) {
			bambooServer.publish(deployStr);
			}

			List<DeploymentPermissions> deployPermissionList = planSpec.deploymentPermission();
			for (DeploymentPermissions deployPermissionStr : deployPermissionList) {
			bambooServer.publish(deployPermissionStr);
			}

			List<EnvironmentPermissions> environmentPermissionsList1 = planSpec.environmentPermission("DEV", "USF-DCT-DevDeployers|DEPLOY|VIEW|EDIT");
			for (EnvironmentPermissions environmentPermissionStr : environmentPermissionsList1) {
			bambooServer.publish(environmentPermissionStr);
			}
			List<EnvironmentPermissions> environmentPermissionsList2 = planSpec.environmentPermission("SIT", "USF-DCT-DevDeployers|DEPLOY|VIEW|EDIT");
			for (EnvironmentPermissions environmentPermissionStr : environmentPermissionsList2) {
			bambooServer.publish(environmentPermissionStr);
			}
			List<EnvironmentPermissions> environmentPermissionsList3 = planSpec.environmentPermission("UAT", "USF-DCT-DevDeployers|DEPLOY|VIEW|EDIT");
			for (EnvironmentPermissions environmentPermissionStr : environmentPermissionsList3) {
			bambooServer.publish(environmentPermissionStr);
			}
			List<EnvironmentPermissions> environmentPermissionsList4 = planSpec.environmentPermission("PERF", "USF-DCT-DevDeployers|DEPLOY|VIEW|EDIT");
			for (EnvironmentPermissions environmentPermissionStr : environmentPermissionsList4) {
			bambooServer.publish(environmentPermissionStr);
			}
			List<EnvironmentPermissions> environmentPermissionsList5 = planSpec.environmentPermission("PRODB", "USF-DCT-ProdDeployers|DEPLOY|VIEW|EDIT;USF-DCT-DevDeployers|VIEW|EDIT;USF-DCT-ASO-ECOM|DEPLOY|VIEW|EDIT");
			for (EnvironmentPermissions environmentPermissionStr : environmentPermissionsList5) {
			bambooServer.publish(environmentPermissionStr);
			}
}

	private static void setProperty(String fileName){
		propertyFileName = fileName;
	}
}