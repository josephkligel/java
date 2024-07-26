package com.codingdojo.manytomany.models;

//...
@Entity
@Table(name="categories_products")
public class CategoryProduct {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="product_id")
 private Product product;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="category_id")
 private Category category;
 
 public CategoryProduct() {
     
 }
 // ...
 // getters and setters removed for brevity
 // ...
}


