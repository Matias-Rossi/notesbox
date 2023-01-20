import React, { useState, Fragment, useEffect } from "react";
import { useMediaQuery } from "react-responsive";
import Select from "react-dropdown-select";
import Category from "~/models/category";

function CategoryPicker({ showChooseText, categories, onChange }) {
  const [category, setCategory] = useState(categories[0].id);
  const categoryCount = categories.length;
  const isMobile = useMediaQuery({ query: '(max-width:620px)' })
  console.log("category count: " + categoryCount)
  console.log(categories);

  useEffect(() => {
    setCategory(categories[0].id);
  }, [categories])


  const [dropdownOptions, setDropdownOptions] = useState([]);


  useEffect(() => {
    const _options = categories.map((c, i) => {
      return { value: i, label: c.name };
    });
    setDropdownOptions(_options);
  }, [categories])

  return (

    /* TODO make drop-down for mobile */
    <div className="">

      <div className={`flex gap-4 sans text-black justify-around items-center text-lg sm:text-base sm:gap-1 sm:justify-center ${isMobile ? "hidden" : "block"}`}>
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
      {isMobile &&

        <Select options={dropdownOptions}
          className
          placeholder="Show..."
          searchable={false}
          style={{ width: "10rem"}}
          onChange={(v) => {
            setCategory(v + 1)
            onChange(v[0].value)
            console.log("onChangeando " + v[0]);
            console.log(v[0])
          }} />
      }
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
