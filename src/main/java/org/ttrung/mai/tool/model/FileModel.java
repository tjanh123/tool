package org.ttrung.mai.tool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude = { "file" })
@AllArgsConstructor
@NoArgsConstructor
public class FileModel {
	private String id;
	private String url;
	private String file;

}
