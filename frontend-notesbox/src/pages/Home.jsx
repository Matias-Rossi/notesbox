import React, { useState, useEffect } from "react";
import musical_box from "~/assets/images/musical_box_1.png";
import CategoryPicker from "~/shared/ui/shop/CategoryPicker";
import Category from "~/models/category";
import MusicalBox from "~/models/musicalBox";
import MusicalBoxGrid from "~/shared/ui/shop/MusicalBoxGrid";
import SecondaryButton from "~/shared/ui/input/SecondaryButton";
import { isEmpty } from "~/shared/utils/utils.js";
import { config } from "~/shared/data/config";
import { FaArrowRight } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

function Home() {
    const defBoxes = [
        new MusicalBox(0, "Jingle Bells", "24", undefined, "Festive"),
        new MusicalBox(1, "Last Christmas", "24", undefined, "Festive"),
        new MusicalBox(2, "Muchachos", "29", undefined, "Sports"),
        new MusicalBox(3, "Arrancarmelo", "29", undefined, "Sports"),
        new MusicalBox(4, "Titanic", "29", undefined, "Movies"),
        new MusicalBox(5, "Mi Enfermedad", "29", undefined, "Other"),
    ];

    const navigate = useNavigate();
    const [specialCollectionIndex, setSpecialCollectionIndex] = useState(0)
    const [specialCollections, setSpecialCollections] = useState([{id: 0, name: "Loading..."}])
    const [melodies, setMelodies] = useState(defBoxes)

    //Fetch products 
    useEffect(() => {
        console.log("Fetching collections");
        fetch(config.backend_url + "/api/products/special-collections")
          .then((response) => response.json())
          .then(
            (data) => {
                let _specialCollections = []
                data.forEach(sc => _specialCollections.push(sc));
                setSpecialCollections(_specialCollections);
                setSpecialCollectionIndex(0);
                setMelodies(MusicalBox.listFromSpecialCollection(_specialCollections[0]));
            },
            (error) => {
              console.error(error);
            }
          );
      }, []);

    //Update when category is changed
    useEffect(() => {
        console.log("ccc")
        console.log(specialCollections);
        console.log(specialCollectionIndex);
        if(!isEmpty(specialCollections)) {
            setMelodies(MusicalBox.listFromSpecialCollection(specialCollections[specialCollectionIndex]));
        }
      }, [specialCollectionIndex]);


    return (
        <main>
            <div className="flex gap-20 my-12 mx-96">
                <img
                    className="w-48 h-48"
                    src={musical_box}
                    alt="Musical box handrawing"
                />
                <div className="flex flex-col flex-grow max-w-md justify-center gap-4">
                    <h1>More than sound</h1>
                    <p className="text-justify">
                        Music is an essential part of our lives. Through it we
                        express emotions, share, and bring important moments
                        back to life. Through musical boxes, you can{" "}
                        <b>make them tangible.</b>
                    </p>
                </div>
            </div>
            <CategoryPicker
                onChange={setSpecialCollectionIndex}
                className="my-6"
                showChooseText={false}
                categories={specialCollections}
            />
            <MusicalBoxGrid className="my-6" boxes={melodies} />
            <div className="flex justify-end my-12 w-1/2">
                <SecondaryButton
                    text="See the full catalog"
                    trailingIcon={<FaArrowRight />}
                    onClick={() => navigate("/catalog")}
                />
            </div>
        </main>
    );
}

export default Home;
