package com.letscodemom;

import com.beust.jcommander.JCommander;
import com.letscodemom.api.APIJobs;
import com.letscodemom.cli.CLIArguments;
import com.letscodemom.cli.CLIFunctions;

import java.util.*;
import java.util.stream.Stream;

import static com.letscodemom.CommanderFunctions.buildCommanderWithName;
import static com.letscodemom.CommanderFunctions.parseArguments;
import static com.letscodemom.api.APIFunctions.buildAPI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        // Obtener un stream de los argumentos que se pasaron por terminal
        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage) //parsea los argumentos y si hay error muestra el mensaje de ayuda
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter(cli -> !cli.isHelp()) //si el argumento es --help no lo toma en cuenta
                        .filter(cli -> cli.getKeyword() != null) //si el argumento es null no lo toma en cuenta
                        .findFirst(); //toma el primer argumento que cumpla con las condiciones anteriores

        cliArgumentsOptional.map(CLIFunctions::toMap) //si el argumento es valido lo mapea a un map
                            .map(Main::executeRequest) //ejecuta la busqueda
                            .orElse(Stream.empty()) //si no hay argumentos validos retorna un stream vacio
                            .forEach(System.out::println); //imprime los resultados

    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        // toma los parametros y ejecuta la busqueda de trabajo con esos parametros
        System.out.println("executeRequest(params) ");
        APIJobs api = buildAPI(APIJobs.class, "https://api.escuelajs.co/api/v1/products");



        return Stream.of((Map<String, Object>) null)
                .map(api::jobs) //ejecuta la busqueda
                .flatMap(Collection::stream); //convierte la coleccion de resultados en un stream

    }
}