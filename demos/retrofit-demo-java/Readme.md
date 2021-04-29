# Retrofit & Livedata Demo for SMD Lab 5

## About 
Demo app implemented using the following APIs and concepts: Retrofit, Livedata & ViewModel, RecyclerView

The purpose of the app is to show the astronauts that are currently in space (on ISS or in transit to it).

The API that provides this data is free and requires no authentication:
[ISS API page](http://api.open-notify.org/)

[Lab page](https://ocw.cs.pub.ro/courses/smd/laboratoare/05)

## Implementation details

The app uses Retrofit to obtain data from the ISS API. We need:
 * classes that model the JSON response we receive
 * a Retrofit service interface for the service calls we need to perform
 
A design practice we recommend is to separate your app's business logic from the UI/UX components.
For this, you can start by using the architecture component offered by Android and called View Model,
like we do in this demo. 

The PeopleInSpaceViewModel is responsible for requesting the data from the PeopleInSpaceRepository,
which in turn retrieves it using retrofit. This makes the implementation details of how we obtain
the data transparent to the MainActivity.

The data (the list of astronauts) is passed using LiveData. It can also be passed using other mechanisms, 
like Observables if using rxJava or rxKotlin, or coroutine flows in Kotlin.

### UI
The data is shown in one activity and consists of:
* a button that triggers the request
* the number of astronauts
* a list of astronauts showing their names and a their spacecraft

For the list we use RecyclerView and created an adapter for its data.

## Useful links and learning materials

[Fun APIs list](https://medium.com/@vicbergquist/18-fun-apis-for-your-next-project-8008841c7be9)
For trying out the APIs: 
[Postman](https://www.postman.com/)
For generating classes from a given json:
[JSON to Objects converter](https://www.jsonschema2pojo.org/)

Codelabs:
* [LiveData](https://developer.android.com/codelabs/kotlin-android-training-live-data#0)
* [ViewModel](https://developer.android.com/codelabs/kotlin-android-training-view-model#0)
* [Kotlin Flow and LiveData](https://developer.android.com/codelabs/advanced-kotlin-coroutines#0)

Articles:
* [MVVM demo](https://medium.com/@amtechnovation/android-architecture-component-mvvm-part-1-a2e7cff07a76)
* [Retrofit and MVVM demo](https://learntodroid.com/consuming-a-rest-api-using-retrofit2-with-the-mvvm-pattern-in-android/)
* [Codelab - Kotlin Flow and LiveData](https://developer.android.com/codelabs/advanced-kotlin-coroutines#0)
* [Kotlin Coroutines and livedata](https://medium.com/androiddevelopers/livedata-with-coroutines-and-flow-part-iii-livedata-and-coroutines-patterns-592485a4a85a)
* [Android Architecture: Hilt, MVVM, Kotlin Coroutines, Live Data, Room and Retrofit](https://itnext.io/android-architecture-hilt-mvvm-kotlin-coroutines-live-data-room-and-retrofit-ft-8b746cab4a06)

Debugging tools:

[Network Interceptor](https://square.github.io/okhttp/interceptors/)

To see the network requests your app does:
* [Flipper](https://fbflipper.com/)
* [Stetho](https://medium.com/dev-genius/stetho-the-ultimate-debugging-tool-for-android-1e7573554d04)

