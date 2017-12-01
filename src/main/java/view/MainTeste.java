package view;

import azure.AzureMLClient;

public class MainTeste {

	public static void main(String[] args) {
		String mlEndPoint = "https://ussouthcentral.services.azureml.net/workspaces/3aaf0945f0e64870b20f83effff01b56/services/f9efe86cbff041c09b7c802e57099a4f/execute?api-version=2.0&format=swagger";
		String mlAPIKey = "lTdwJUFatd/cnIXaPCVfzxdLGe6LwkvmcdC4sWfdda4MO9tw1pOxTMbSqZkylTVFVd40lW3gWLtkPb7khCCB3w==";
		String requestBody = "{\"Inputs\":{\"input1\": [{\"sepal_length\": 5.1,\"sepal_width\": 3.5,\"petal_length\": 1.4,\"petal_width\": 0.2,\"class\": \"Iris-setosa\"}]},\"GlobalParameters\": {}}";

		AzureMLClient myMLClient = new AzureMLClient(mlEndPoint, mlAPIKey);
		try {
			String response = myMLClient.requestResponse(requestBody);
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
