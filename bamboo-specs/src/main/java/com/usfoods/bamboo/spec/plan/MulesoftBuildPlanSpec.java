package com.usfoods.bamboo.spec.plan;

import com.atlassian.bamboo.specs.api.BambooSpec;
import com.atlassian.bamboo.specs.api.builders.plan.Plan;
import com.atlassian.bamboo.specs.api.builders.permission.PlanPermissions;
import com.atlassian.bamboo.specs.util.BambooServer;
import com.usfoods.bamboo.spec.standard.pipeline.StandardMulesoftBuildPlanSpec;

@BambooSpec
public class MulesoftBuildPlanSpec extends StandardMulesoftBuildPlanSpec
{


	public static String PROPERTY_NAME = "pim-product-prc-api-mulesoft-project.properties";

	public static void main(String... argv) {
	  //By default credentials are read from the '.credentials' file.
		setProperty(PROPERTY_NAME);
		init();
		BambooServer bambooServer = new BambooServer(projectProp.getBambooHostname());
		final MulesoftBuildPlanSpec planSpec = new MulesoftBuildPlanSpec();

		final Plan plan = planSpec.plan();
		bambooServer.publish(plan);

		final PlanPermissions planPermission = planSpec.planPermissions();
		bambooServer.publish(planPermission);
	}

	private static void setProperty(String fileName){
		propertyFileName = fileName;
	}
}