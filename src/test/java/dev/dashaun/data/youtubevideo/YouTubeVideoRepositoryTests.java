package dev.dashaun.data.youtubevideo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class YouTubeVideoRepositoryTests {

	private static final Logger log = LoggerFactory.getLogger(YouTubeVideoRepositoryTests.class);

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private YouTubeVideoRepository repository;

	@Test
	public void testFindById() {
		log.info("Persisting a new YouTubeVideo");
		YouTubeVideo youTubeVideo = new YouTubeVideo();
		youTubeVideo.setDate("Jan 6, 2021");
		youTubeVideo.setId("Vkd7g9BCNLs");
		youTubeVideo.setLink("https://www.youtube.com/watch?v=Vkd7g9BCNLs");
		youTubeVideo.setTitle("Hello, I'm DaShaun");
		youTubeVideo.setDescription("Introducing myself, and my new journey.");
		entityManager.persist(youTubeVideo);

		log.info("Retrieving with ID = {}", youTubeVideo.getId());
		Optional<YouTubeVideo> findById = repository.findById(youTubeVideo.getId());
		assertThat(findById).isPresent();
		assertThat(findById.get()).isEqualTo(youTubeVideo);
	}

}
