package controller.azure;

import azure.AzureMLClient;
import model.Iris;

public class IrisClassController {

	public String getIrisClass(Iris iris) throws Exception {
		String mlEndPoint = "https://ussouthcentral.services.azureml.net/workspaces/3aaf0945f0e64870b20f83effff01b56/services/f9efe86cbff041c09b7c802e57099a4f/execute?api-version=2.0&format=swagger";
		String mlAPIKey = "lTdwJUFatd/cnIXaPCVfzxdLGe6LwkvmcdC4sWfdda4MO9tw1pOxTMbSqZkylTVFVd40lW3gWLtkPb7khCCB3w==";
		String requestBody = "{\"Inputs\":{\"input1\": [{\"sepal_length\":" + iris.getSepalLength()
				+ ",\"sepal_width\":" + iris.getSepalWidth() + ",\"petal_length\":" + iris.getPetalLength()
				+ ",\"petal_width\":" + iris.getPetalWidth() + ",\"class\": \"\"}]},\"GlobalParameters\": {}}";
		AzureMLClient myMLClient = new AzureMLClient(mlEndPoint, mlAPIKey);
		String response = myMLClient.requestResponse(requestBody);
		return scoredLabel(response);
//		{"Results":{"output1":[{"Scored Labels":"Iris-setosa"}]}}
		
	}

	private String scoredLabel(String response) {
		response = response.substring(response.lastIndexOf(":") + 1, response.length());
		
		response = response.replace("}", "");
		response = response.replace("]", "");
		response = response.replace("\"", "");
		
		return response;
	}

}
