package com.codingdojo.manytomany.models;

//..
@Entity
@Table(name="categories")
public class ManyToManyProduct {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @OneToMany(mappedBy="category", fetch=FetchType.LAZY)
 private List<CategoryProduct> products;
 
 public ManyToManyProduct() {
     
 }
 
 // ...
 // getters and setters removed for brevity
 // ...
}


