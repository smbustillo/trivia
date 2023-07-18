package com.smbustillo.trivia;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ChatGPTClient {

    public String enviarPregunta(String pregunta) {
        String respuesta = "";

        String apiKey = "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"; // Reemplaza "tu_api_key" con tu clave de API de OpenAI

        try {
            String url = "https://api.openai.com/v1/chat/completions";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Configuración de la conexión
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);

            // Cuerpo de la solicitud en formato JSON
            String postData = "{\"model\": \"gpt-3.5-turbo\", " +
                    "\"messages\": [{\"role\": \"system\", " +
                    "\"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"Hola, cuéntame un chiste.\"}]}";

            // Envío de la solicitud POST
            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);
                wr.write(postDataBytes);
            }

            int responseCode = con.getResponseCode();
            BufferedReader in;

            if (responseCode == HttpURLConnection.HTTP_OK) {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }else {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Manejo de la respuesta (aquí puedes procesar la respuesta JSON)
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return respuesta;
    }
}
