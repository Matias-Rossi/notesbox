import React from "react";
import { useNavigate } from "react-router-dom";
import { config } from "~/shared/data/config";
import CategoryPicker from "~/shared/ui/shop/CategoryPicker";
import Category from "~/models/category";
import MusicalBoxGrid from "~/shared/ui/shop/MusicalBoxGrid";
import SecondaryButton from "~/shared/ui/input/SecondaryButton";
import { FaArrowRight } from "react-icons/fa";
import MusicalBox from "~/models/musicalBox";
import { useState, useEffect } from "react";

function Catalog() {
    const navigate = useNavigate();
    const [categories, setCategories] = useState([new Category(-1, "Loading")]);
    const [categoryIndex, setCategoryIndex] = useState(0);
    const [melodies, setMelodies] = useState([]);
    const [displayedMelodies, setDisplayedMelodies] = useState([]);

    //Data fetch
    useEffect(() => {
        //Categories
        fetch(config.backend_url + "/api/products/category-names")
            .then((response) => response.json())
            .then(
                (data) => {
                    //Do something
                    let _categories = [new Category(0, "All")];
                    data.forEach((c, i) => _categories.push(new Category(i+2, c)));
                    setCategories(_categories);
                },
                (error) => {
                    console.error(error);
                }
            );
        //Melodies
        fetch(config.backend_url + "/api/products/melodies")
            .then((response) => response.json())
            .then(
                (data) => {
                    //Do something
                    let _melodies = [];
                    data.forEach((m) => _melodies.push(MusicalBox.fromProduct(m)));
                    setMelodies(_melodies);
                },
                (error) => {
                    console.error(error);
                }
            );
    }, [])

    //Refresh displayed products according to selected category
    useEffect(() => {
        if(categoryIndex === 0) {
            setDisplayedMelodies(melodies);
        } else {
            let categoryName = categories[categoryIndex].name;
            let _displayedMelodies = melodies.filter(m => m.categoryDisplayName === categoryName);
            setDisplayedMelodies(_displayedMelodies);
        }
    }, [categoryIndex, melodies])


    console.log("CATEGORIES");
    console.log(categories)

    return (
        <main className="my-12 mb-auto">
            <CategoryPicker
                className="my-6 "
                showChooseText={true}
                categories={categories}
                onChange={setCategoryIndex}
            />
            <MusicalBoxGrid className="my-6" boxes={displayedMelodies} />
            <div className="flex justify-end my-12 w-1/2">
                <SecondaryButton
                    text="See current trends"
                    trailingIcon={<FaArrowRight />}
                    onClick={() => navigate("/")}
                />
            </div>
        </main>
    );
}

export default Catalog;
