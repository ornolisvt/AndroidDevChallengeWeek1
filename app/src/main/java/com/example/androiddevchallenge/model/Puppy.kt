/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.model

data class Puppy(
    val age: String,
    val breed: String,
    val color: String,
    val gender: String,
    val id: Int,
    val name: String,
    val photo: String,
    val photoCropped: String,
    val size: String,
    val adoptable: Boolean = false,
)

object PuppyRepository {
    fun listPuppies(): List<Puppy> = puppies
    fun getPuppy(id: Int): Puppy = puppies.find { it.id == id }!!
}

val puppies = listOf(
    Puppy(
        "Adult",
        "Shepherd",
        "Apricot / Beige",
        "Male",
        50658891,
        "Van Gogh",
        "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658891/1/?bust=1614274067&width=300",
        "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658891/1/?bust=1614274067&width=450",
        "Medium",
        true
    ),
    Puppy(
        "Baby",
        "Hound",
        "Black & Brow / Chocolate",
        "Male",
        50658910,
        "Billy",
        "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658910/1/?bust=1614274302&width=300",
        "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658910/1/?bust=1614274302&width=450",
        "Small",
        true
    ),
    Puppy(
        "Young",
        "Chihuahua",
        "Golden",
        "Male",
        50658861,
        "Bear",
        "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658861/1/?bust=1614274216&width=300",
        "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658861/1/?bust=1614274216&width=450",
        "Medium",
        true
    ),
    Puppy(
        id = 50551695,
        breed = "Retriever",
        color = "Yellow",
        age = "Young",
        gender = "Male",
        size = "Medium",
        name = "Marble",
        photo = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50551695/2/?bust=1614272572&width=300",
        photoCropped = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50551695/2/?bust=1614272572&width=450",
        adoptable = true
    ),
    Puppy(
        id = 50616935,
        breed = "Pit Bull Terrier",
        color = "Black & Chocolate",
        age = "Adult",
        gender = "Female",
        size = "Medium",
        name = "Dolly",
        photo = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50616935/1/?bust=1614272519&width=300",
        photoCropped = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50616935/1/?bust=1614272519&width=450",
        adoptable = true
    ),
    Puppy(
        id = 50658845,
        breed = "Chihuahua",
        color = "Brown / Chocolate",
        age = "Young",
        gender = "Male",
        size = "Small",
        name = "Tanner",
        photo = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658845/1/?bust=1614273776&width=300",
        photoCropped = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658845/1/?bust=1614273776&width=450",
        adoptable = true
    ),
    Puppy(
        id = 50616947,
        breed = "American Bulldog",
        color = "Black & White",
        age = "Adult",
        gender = "Female",
        size = "Large",
        name = "Sweet Pea",
        photo = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50616947/3/?bust=1614273434&width=300",
        photoCropped = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50616947/3/?bust=1614273434&width=450",
        adoptable = true
    ),

    Puppy(
        id = 50658899,
        breed = "Pit Bull Terrier",
        age = "Adult",
        color = "White with spots",
        gender = "Female",
        size = "Medium",
        name = "Sugarplum",
        photo = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658899/1/?bust=1614274219&width=300",
        photoCropped = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658899/1/?bust=1614274219&width=450",
        adoptable = true
    ),
    Puppy(
        id = 50658674,
        breed = "Bull Terrier",
        color = "White / Cream",
        age = "Young",
        gender = "Male",
        size = "Medium",
        name = "Geralt",
        photo = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658674/1/?bust=1614273480&width=300",
        photoCropped = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50658674/1/crop/?bust=1614273480&width=450",
        adoptable = true
    ),
)
