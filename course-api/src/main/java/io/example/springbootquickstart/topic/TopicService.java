package io.example.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topics> topics = new ArrayList<> (Arrays.asList(
			new Topics("spring", "Spring Framework", "Spring Framework Description"),
			new Topics("java", "Java Framework", "Java Framework Description"),
			new Topics("javascript", "JavaScript Framework", "JavaScript Framework Description")
			));
	
	public List<Topics> getAllTopics() {
		return topics;
	}
	
	public Topics getTopic(String id) {
		
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopics(Topics topic) {
		topics.add(topic);
	}

	public void updateTopics(String id, Topics topics2) {
		for(int i = 0; i < topics.size(); i++) {
			Topics t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topics2);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
