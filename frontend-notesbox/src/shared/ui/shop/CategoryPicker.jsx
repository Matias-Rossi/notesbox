import React, { useState, Fragment, useEffect } from "react";
import Category from "~/models/category";

function CategoryPicker({ showChooseText, categories, onChange }) {
  const [category, setCategory] = useState(categories[0].id);
  const categoryCount = categories.length;
  console.log("category count: " + categoryCount)
  console.log(categories);

  useEffect(() => {
    setCategory(categories[0].id);
  }, [categories])


  return (
    <div className="flex gap-4 sans text-black justify-around items-center text-lg">
      {showChooseText ? "Choose a category: " : ""}
      {categories.map((c, i) => {
        return (
          <React.Fragment key={i}>
            <CategoryButton
              category={c}
              onClick={() => {
                setCategory(i + 1)
                onChange(i)
              }}
              selectedCategory={category}
            />
            {i + 1 < categoryCount ? <Divider /> : null}
          </React.Fragment>
        );
      })}
    </div>
  );
}

export default CategoryPicker;

function CategoryButton({ category, onClick, selectedCategory }) {
  console.log("SELECTED CATEGORY");
  console.log(selectedCategory);
  console.log(category.id);
  let isActive = selectedCategory === category.id;
  return (
    <button
      className={`sans ${isActive ? "font-bold" : "font-normal"}`}
      onClick={() => onClick()}
    >
      {" "}
      {category.name}{" "}
    </button>
  );
}

function Divider() {
  return (
    <div
      className="w-5 h-0 border border-black-75"
      style={{ transform: "rotate(-90deg)" }}
    />
  );
}
