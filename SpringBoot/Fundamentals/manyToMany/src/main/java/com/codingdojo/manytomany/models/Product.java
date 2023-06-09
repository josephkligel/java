package com.codingdojo.manytomany.models;

//...
@Entity
@Table(name="products")
public class Product {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 private String description;
 private double price;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @OneToMany(mappedBy="product", fetch=FetchType.LAZY)
 private List<CategoryProduct> categories;
 
 public Product() {
     
 }
 // ...
 // getters and setters removed for brevity
 // ...
}

