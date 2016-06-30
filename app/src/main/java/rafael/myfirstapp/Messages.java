package rafael.myfirstapp;

import java.util.Random;
import java.util.TreeSet;

/**
 * Created by rafael on 26/06/16.
 */
public class Messages {

    private TreeSet<Integer> chosen;

    public Messages(){
        chosen = new TreeSet<>();
    }

    private static String[] messages = {
            "Oi, hoje é um belo dia, não? :)",
            "Este app foi feito de coração!",
            "Espero que esteja gostando desta aplicação.",
            "Programar é divertido! Deverias tentar um dia! :D",
            "Lembre-se sempre de descansar!",
            "Uma soneca depois do almoço é bom para a mente.",
            "Já pensou em estudar algo novo para treinar a mente?"
    };

    public String getRandomMessage(){
        Random r = new Random();
        Integer i = r.nextInt(messages.length);

        if(chosen.size() >= messages.length){
            chosen.clear();
        }

        while(chosen.contains(i)){
            i = r.nextInt(messages.length);
        }

        chosen.add(i);

        return messages[i];
    }

}
