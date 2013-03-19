package br.com.mercadolibre.sdk.category;

import java.io.Serializable;
import java.util.List;

import br.com.mercadolibre.sdk.settings.Settings;

import com.google.gson.annotations.SerializedName;

public class Category implements Serializable {

	private static final long serialVersionUID = 2383571891999037650L;
	
	private String id;
	
	private String name;
	
	private String permalink;
	
	@SerializedName("total_items_in_this_category")
	private Long totalItemsInThisCategory;
	
	@SerializedName("path_from_root")
	private List<CategoryBasicInfo> root;
	
	@SerializedName("children_categories")
	private List<CategoryChildrenBasicInfo> childrenCategories;
	
	private Settings settings;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public Long getTotalItemsInThisCategory() {
		return totalItemsInThisCategory;
	}

	public void setTotalItemsInThisCategory(Long totalItemsInThisCategory) {
		this.totalItemsInThisCategory = totalItemsInThisCategory;
	}

	public List<CategoryBasicInfo> getRoot() {
		return root;
	}

	public void setRoot(List<CategoryBasicInfo> root) {
		this.root = root;
	}

	public List<CategoryChildrenBasicInfo> getChildrenCategories() {
		return childrenCategories;
	}

	public void setChildrenCategories(
			List<CategoryChildrenBasicInfo> childrenCategories) {
		this.childrenCategories = childrenCategories;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((permalink == null) ? 0 : permalink.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (permalink == null) {
			if (other.permalink != null)
				return false;
		} else if (!permalink.equals(other.permalink))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", permalink="
				+ permalink + ", totalItemsInThisCategory="
				+ totalItemsInThisCategory + ", root=" + root + "]";
	}

}
