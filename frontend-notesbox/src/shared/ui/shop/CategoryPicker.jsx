import React, { useState, Fragment } from "react";
import Category from "~/models/category";

function CategoryPicker({ showChooseText, categories, onChange }) {
  const [category, setCategory] = useState(categories[0].id);
  const categoryCount = categories.length;
  console.log("category count: " + categoryCount)
  console.log(categories);

  return (
    <div className="flex gap-4 sans text-black justify-around items-center text-lg">
      {showChooseText ? "Choose a category: " : ""}
      {categories.map((c, i) => {
        return (
          <React.Fragment key={i}>
            <CategoryButton
              category={c}
              onClick={() => {
                setCategory(c.id)
                onChange(c.id)
              }}
              selectedCategory={category}
            />
            {++i < categoryCount ? <Divider /> : null}
          </React.Fragment>
        );
      })}
    </div>
  );
}

export default CategoryPicker;

function CategoryButton({ category, onClick, selectedCategory }) {
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
