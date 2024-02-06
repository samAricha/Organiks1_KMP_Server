<p align="center"><img src="art/app_logo.png" alt="MealTime" height="150px"></p>

# Organiks
Organiks Platform combines Compose Multiplatform app(Android, Desktop) + KTOR server + Gemini AI aimed at being the digitizing tool for the Agricultural Sector which has been neglected
in terms of Technology here in Africa which.

Organiks is a story of two friends with a Love for Agriculture, one a MicroBiologist and the other a Techie in love with Compose.

The Platform aims at being a Farmers Offline First tool to store their farm records even when offline and when
they have access to Internet Connection they can backup their data(i.e Offline First) to
the backend Server also within the project.

In combination with Offline First Record Keeping, Organiks has implemented the Gemini AI LLM which acts as a farmers assistant whether they might have doubts
whether their birds, animals or plants have been attacked by diseases inline with Googles promise of "a world responsibly empowered by AI".

## 🛠️ Prerequisites 🛠️
#### IDE
You can either use [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Android Studio](https://developer.android.com/studio/).



> For Gemini AI Assistant.
#### Gemini Api Key
You can get your key here [Google AI Studio](https://makersuite.google.com/app/prompts/new_freeform) and replace it in GeminiApi.kt file
in this folder structure(change folder structure to Project from Android) Shared>Src>commonMain>kotlin>com>teka>organiks>feature>ai_assistant>GeminiApi.kt



> For KTOR Server.
#### Mysql for running 
1. In order to save data to db from KTOR Server you will have to install MySQL on your machine and get the 
user-name and password after which you replace them in Data.kt plugin file in the following structure
Server>Src>main>kotlin>com>teka>organiks>plugins>Data.kt

2. In your Mysql Server you will require a database named organiks

3. In order to access you running backend server remotely in your Android or Desktop you can use [Ngrok](https://ngrok.com/) using the following instructions [Ngrok Setup](https://ngrok.com/docs/getting-started/?os=macos)
  - After setting up your Ngrok and getting your URL, you will have to replace the test_url under HttpClientProvider in the following structure
    Shared>Src>commonMain>kotlin>com>teka>organiks>core>data>remote>HttpClientProvider


## Screenshots
### Android
<img src="art/android_screen1.jpeg"  width="250"/>  <img src="art/android_screen2.jpeg"  width="250"/>  <img src="art/android_screen3.jpeg" width="250"/>  <img src="art/android_screen4.jpeg" width="250"/>

### Desktop
<img src="art/dsk_screen1.png"/> <img src="art/dsk_screen2.png"/>  <img src="art/dsk_screen3.png"/>  <img src="art/dsk_screen4.png"/>

## Architecture
The app is shared between Android, Desktop with Compose Multiplatform and Server with Ktor within the same project.
### Modules
- shared:
  - contains all the shared code between the platforms
- android:
  - contains the android app
- desktop:
  - contains the desktop app
- server:
  - contains the backend ktor app

## Built with
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) - The Kotlin Multiplatform technology is designed to simplify the development of cross-platform projects.
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) -  a modern UI framework for Kotlin that makes building performant and beautiful user interfaces easy and enjoyable.
- [Ktor Server](https://ktor.io/docs/intellij-idea.html) -  Ktor is an asynchronous framework for creating microservices, web applications.
- [Ktor Client](https://ktor.io/docs/getting-started-ktor-client.html) -  a multiplatform asynchronous HTTP client, which allows you to make requests and handle responses.
- [Gemini AI](https://deepmind.google/technologies/gemini) - a multi-modal large language model(LLM) developed by Google DeepMind.
- [SQLDelight](https://github.com/cashapp/sqldelight) - SQLDelight is an open-source library developed by Cash App (formerly Square, Inc.) for working with SQL databases in Kotlin-based Android and multi-platform applications.
- [Multiplatform Settings](https://github.com/russhwolf/multiplatform-settings) - A Kotlin Multiplatform library for saving simple key-value data.
- [Koin](https://insert-koin.io/) - The pragmatic Kotlin & Kotlin Multiplatform Dependency Injection framework.
- [Voyager](https://voyager.adriel.cafe/) - A multiplatform navigation library.
- [Kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime) - KotlinX multiplatform date/time library.
- [Kotlinx-serilization](https://github.com/Kotlin/kotlinx.serialization) - Kotlin multiplatform / multi-format serialization.

## Run project
### Android
To run the application on android device/emulator:
- open project in Android Studio and run imported android run configuration

### Desktop
Run the desktop application: `./gradlew :desktop:run`

### Server
To run the KTOR Server:
- open project and access the Application.kt file under Server Folder 
- run the main method in the Application.kt file
- N:B ==> In order to run Ktor Server you will require MySQL installed on your machine and have a DB named organiks


## License
```xml
Copyright (c) 2024 Aricha Samson

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
```  

  
