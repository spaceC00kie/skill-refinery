package fun_facts.fun_facts_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    @GetMapping("/api")
    public List<Map<String, Object>> getApi() {
        List<Map<String, Object>> facts = new ArrayList<>();

        Map<String, Object> fact1 = new HashMap<>();
        fact1.put("factId", 1);
        fact1.put("title", "Ocean Depth");
        fact1.put("description", "The deepest part of the ocean is the Mariana Trench, which reaches a depth of approximately 36,070 feet (10,994 meters).");
        facts.add(fact1);

        Map<String, Object> fact2 = new HashMap<>();
        fact2.put("factId", 2);
        fact2.put("title", "Human Brain");
        fact2.put("description", "The human brain contains approximately 86 billion neurons, each connected to thousands of other neurons.");
        facts.add(fact2);

        Map<String, Object> fact3 = new HashMap<>();
        fact3.put("factId", 3);
        fact3.put("title", "Mount Everest Growth");
        fact3.put("description", "Mount Everest, the tallest mountain on Earth, grows about 4 millimeters every year due to geological uplift.");
        facts.add(fact3);

        Map<String, Object> fact4 = new HashMap<>();
        fact4.put("factId", 4);
        fact4.put("title", "Speed of Light");
        fact4.put("description", "Light travels at a speed of approximately 299,792 kilometers per second (186,282 miles per second) in a vacuum.");
        facts.add(fact4);

        Map<String, Object> fact5 = new HashMap<>();
        fact5.put("factId", 5);
        fact5.put("title", "Oldest Tree");
        fact5.put("description", "The oldest known tree, a Great Basin Bristlecone Pine, is over 5,000 years old and is located in California's White Mountains.");
        facts.add(fact5);

        Map<String, Object> fact6 = new HashMap<>();
        fact6.put("factId", 6);
        fact6.put("title", "Antarctic Desert");
        fact6.put("description", "Antarctica is the largest desert in the world, receiving less than 2 inches of precipitation annually in some areas.");
        facts.add(fact6);

        Map<String, Object> fact7 = new HashMap<>();
        fact7.put("factId", 7);
        fact7.put("title", "Human Cells");
        fact7.put("description", "The human body is composed of approximately 37.2 trillion cells, with about 200 different types of cells.");
        facts.add(fact7);

        Map<String, Object> fact8 = new HashMap<>();
        fact8.put("factId", 8);
        fact8.put("title", "Moon Distance");
        fact8.put("description", "The average distance from the Earth to the Moon is about 384,400 kilometers (238,855 miles).");
        facts.add(fact8);

        Map<String, Object> fact9 = new HashMap<>();
        fact9.put("factId", 9);
        fact9.put("title", "Honey Never Spoils");
        fact9.put("description", "Honey is the only food that doesn't spoil. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still perfectly edible.");
        facts.add(fact9);

        Map<String, Object> fact10 = new HashMap<>();
        fact10.put("factId", 10);
        fact10.put("title", "Lightning Strikes");
        fact10.put("description", "Earth experiences an estimated 8.6 million lightning strikes per day, or about 100 strikes per second.");
        facts.add(fact10);

        Map<String, Object> fact11 = new HashMap<>();
        fact11.put("factId", 11);
        fact11.put("title", "Largest Living Organism");
        fact11.put("description", "The largest living organism is a fungus known as Armillaria, which covers over 2,385 acres in Oregon's Malheur National Forest.");
        facts.add(fact11);

        Map<String, Object> fact12 = new HashMap<>();
        fact12.put("factId", 12);
        fact12.put("title", "Venus Rotation");
        fact12.put("description", "A day on Venus (one full rotation) takes 243 Earth days, making a day on Venus longer than its year.");
        facts.add(fact12);

        Map<String, Object> fact13 = new HashMap<>();
        fact13.put("factId", 13);
        fact13.put("title", "Tardigrade Resilience");
        fact13.put("description", "Tardigrades, also known as water bears, can survive extreme environments, including the vacuum of space, radiation, and temperatures from just above absolute zero to over 300°F (150°C).");
        facts.add(fact13);

        Map<String, Object> fact14 = new HashMap<>();
        fact14.put("factId", 14);
        fact14.put("title", "Shark Teeth");
        fact14.put("description", "Sharks can grow and lose tens of thousands of teeth in their lifetime. Some species replace teeth as often as every few weeks.");
        facts.add(fact14);

        Map<String, Object> fact15 = new HashMap<>();
        fact15.put("factId", 15);
        fact15.put("title", "Deepest Cave");
        fact15.put("description", "The Krubera Cave in Georgia's Western Caucasus is the deepest known cave in the world, descending to a depth of 7,208 feet (2,197 meters).");
        facts.add(fact15);

        return facts;
    }
}
