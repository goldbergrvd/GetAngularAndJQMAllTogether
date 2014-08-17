
package test.phone.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import test.phone.model.Phone;

@Path("/phones")
public class PhoneCtrl {
    @Context ServletContext context;

    @GET
    @Produces(APPLICATION_JSON)
    public List<Phone> getAllPhones() {
        System.out.println("get phones");
        try {
            String phonesJsonPath = context.getRealPath("/WEB-INF/classes/phones.json");
            String phonesContent = new String(Files.readAllBytes(Paths.get(phonesJsonPath)));
            Type type = new TypeToken<List<Phone>>(){}.getType();
            return new Gson().fromJson(phonesContent, type);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

}
