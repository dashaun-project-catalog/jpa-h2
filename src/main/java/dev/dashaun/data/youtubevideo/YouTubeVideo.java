package dev.dashaun.data.youtubevideo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
class YouTubeVideo {

	private @Id String id;

	private String link;

	private String description;

	private String title;

	private String thumbnail;

	private String date;

	private long dateVal;

}
