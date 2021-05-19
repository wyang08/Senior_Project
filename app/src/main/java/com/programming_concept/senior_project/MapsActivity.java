package com.programming_concept.senior_project;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AddressComponents;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlusCode;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{

private static Marker markerObj;
private static GoogleMap googleMap;
private static final String TAG = "Info: ";


	@Override
	public void onMapReady(GoogleMap googleMap)
		{

		// Add a marker in Sydney and move the camera
		LatLng nyit = new LatLng(40.76977, -73.98229);
		googleMap.addMarker(new MarkerOptions().position(nyit).title("Marker at NYIT Manhattan campus"));
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(nyit));
		Place questDiagnostics = new Place()
		{
			@Nullable
			@Override
			public String getAddress()
				{
				return null;
				}

			@Nullable
			@Override
			public AddressComponents getAddressComponents()
				{
				return null;
				}

			@Nullable
			@Override
			public BusinessStatus getBusinessStatus()
				{
				return null;
				}

			@Nullable
			@Override
			public List<String> getAttributions()
				{
				return null;
				}

			@Nullable
			@Override
			public String getId()
				{
				return null;
				}

			@Nullable
			@Override
			public LatLng getLatLng()
				{
				return new LatLng(40.76770, -73.98370);
				}

			@Nullable
			@Override
			public String getName()
				{
				return null;
				}

			@Nullable
			@Override
			public OpeningHours getOpeningHours()
				{
				return null;
				}

			@Nullable
			@Override
			public String getPhoneNumber()
				{
				return null;
				}

			@Nullable
			@Override
			public List<PhotoMetadata> getPhotoMetadatas()
				{
				return null;
				}

			@Nullable
			@Override
			public PlusCode getPlusCode()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getPriceLevel()
				{
				return null;
				}

			@Nullable
			@Override
			public Double getRating()
				{
				return null;
				}

			@Nullable
			@Override
			public List<Type> getTypes()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getUserRatingsTotal()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getUtcOffsetMinutes()
				{
				return null;
				}

			@Nullable
			@Override
			public LatLngBounds getViewport()
				{
				return null;
				}

			@Nullable
			@Override
			public Uri getWebsiteUri()
				{
				return null;
				}

			@Override
			public int describeContents()
				{
				return 0;
				}

			@Override
			public void writeToParcel(Parcel parcel, int i)
				{

				}
		};
		Place cvs = new Place()
		{
			@Nullable
			@Override
			public String getAddress()
				{
				return null;
				}

			@Nullable
			@Override
			public AddressComponents getAddressComponents()
				{
				return null;
				}

			@Nullable
			@Override
			public BusinessStatus getBusinessStatus()
				{
				return null;
				}

			@Nullable
			@Override
			public List<String> getAttributions()
				{
				return null;
				}

			@Nullable
			@Override
			public String getId()
				{
				return null;
				}

			@Nullable
			@Override
			public LatLng getLatLng()
				{
				return new LatLng(40.76702, -73.98235);
				}

			@Nullable
			@Override
			public String getName()
				{
				return null;
				}

			@Nullable
			@Override
			public OpeningHours getOpeningHours()
				{
				return null;
				}

			@Nullable
			@Override
			public String getPhoneNumber()
				{
				return null;
				}

			@Nullable
			@Override
			public List<PhotoMetadata> getPhotoMetadatas()
				{
				return null;
				}

			@Nullable
			@Override
			public PlusCode getPlusCode()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getPriceLevel()
				{
				return null;
				}

			@Nullable
			@Override
			public Double getRating()
				{
				return null;
				}

			@Nullable
			@Override
			public List<Type> getTypes()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getUserRatingsTotal()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getUtcOffsetMinutes()
				{
				return null;
				}

			@Nullable
			@Override
			public LatLngBounds getViewport()
				{
				return null;
				}

			@Nullable
			@Override
			public Uri getWebsiteUri()
				{
				return null;
				}

			@Override
			public int describeContents()
				{
				return 0;
				}

			@Override
			public void writeToParcel(Parcel parcel, int i)
				{

				}
		};
		Place the24HourDoc = new Place()
		{
			@Nullable
			@Override
			public String getAddress()
				{
				return null;
				}

			@Nullable
			@Override
			public AddressComponents getAddressComponents()
				{
				return null;
				}

			@Nullable
			@Override
			public BusinessStatus getBusinessStatus()
				{
				return null;
				}

			@Nullable
			@Override
			public List<String> getAttributions()
				{
				return null;
				}

			@Nullable
			@Override
			public String getId()
				{
				return null;
				}

			@Nullable
			@Override
			public LatLng getLatLng()
				{
				return new LatLng(40.76315, -73.97728);
				}

			@Nullable
			@Override
			public String getName()
				{
				return null;
				}

			@Nullable
			@Override
			public OpeningHours getOpeningHours()
				{
				return null;
				}

			@Nullable
			@Override
			public String getPhoneNumber()
				{
				return null;
				}

			@Nullable
			@Override
			public List<PhotoMetadata> getPhotoMetadatas()
				{
				return null;
				}

			@Nullable
			@Override
			public PlusCode getPlusCode()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getPriceLevel()
				{
				return null;
				}

			@Nullable
			@Override
			public Double getRating()
				{
				return null;
				}

			@Nullable
			@Override
			public List<Type> getTypes()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getUserRatingsTotal()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getUtcOffsetMinutes()
				{
				return null;
				}

			@Nullable
			@Override
			public LatLngBounds getViewport()
				{
				return null;
				}

			@Nullable
			@Override
			public Uri getWebsiteUri()
				{
				return null;
				}

			@Override
			public int describeContents()
				{
				return 0;
				}

			@Override
			public void writeToParcel(Parcel parcel, int i)
				{

				}
		};
		Place clearMd = new Place()
		{
			@Nullable
			@Override
			public String getAddress()
				{
				return null;
				}

			@Nullable
			@Override
			public AddressComponents getAddressComponents()
				{
				return null;
				}

			@Nullable
			@Override
			public BusinessStatus getBusinessStatus()
				{
				return null;
				}

			@Nullable
			@Override
			public List<String> getAttributions()
				{
				return null;
				}

			@Nullable
			@Override
			public String getId()
				{
				return null;
				}

			@Nullable
			@Override
			public LatLng getLatLng()
				{
				return new LatLng(40.77632, -73.98301);
				}

			@Nullable
			@Override
			public String getName()
				{
				return null;
				}

			@Nullable
			@Override
			public OpeningHours getOpeningHours()
				{
				return null;
				}

			@Nullable
			@Override
			public String getPhoneNumber()
				{
				return null;
				}

			@Nullable
			@Override
			public List<PhotoMetadata> getPhotoMetadatas()
				{
				return null;
				}

			@Nullable
			@Override
			public PlusCode getPlusCode()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getPriceLevel()
				{
				return null;
				}

			@Nullable
			@Override
			public Double getRating()
				{
				return null;
				}

			@Nullable
			@Override
			public List<Type> getTypes()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getUserRatingsTotal()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getUtcOffsetMinutes()
				{
				return null;
				}

			@Nullable
			@Override
			public LatLngBounds getViewport()
				{
				return null;
				}

			@Nullable
			@Override
			public Uri getWebsiteUri()
				{
				return null;
				}

			@Override
			public int describeContents()
				{
				return 0;
				}

			@Override
			public void writeToParcel(Parcel parcel, int i)
				{

				}
		};
		Place totalHealth = new Place()
		{
			@Nullable
			@Override
			public String getAddress()
				{
				return null;
				}

			@Nullable
			@Override
			public AddressComponents getAddressComponents()
				{
				return null;
				}

			@Nullable
			@Override
			public BusinessStatus getBusinessStatus()
				{
				return null;
				}

			@Nullable
			@Override
			public List<String> getAttributions()
				{
				return null;
				}

			@Nullable
			@Override
			public String getId()
				{
				return null;
				}

			@Nullable
			@Override
			public LatLng getLatLng()
				{
				return new LatLng(40.76424, -73.96954);
				}

			@Nullable
			@Override
			public String getName()
				{
				return null;
				}

			@Nullable
			@Override
			public OpeningHours getOpeningHours()
				{
				return null;
				}

			@Nullable
			@Override
			public String getPhoneNumber()
				{
				return null;
				}

			@Nullable
			@Override
			public List<PhotoMetadata> getPhotoMetadatas()
				{
				return null;
				}

			@Nullable
			@Override
			public PlusCode getPlusCode()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getPriceLevel()
				{
				return null;
				}

			@Nullable
			@Override
			public Double getRating()
				{
				return null;
				}

			@Nullable
			@Override
			public List<Type> getTypes()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getUserRatingsTotal()
				{
				return null;
				}

			@Nullable
			@Override
			public Integer getUtcOffsetMinutes()
				{
				return null;
				}

			@Nullable
			@Override
			public LatLngBounds getViewport()
				{
				return null;
				}

			@Nullable
			@Override
			public Uri getWebsiteUri()
				{
				return null;
				}

			@Override
			public int describeContents()
				{
				return 0;
				}

			@Override
			public void writeToParcel(Parcel parcel, int i)
				{

				}
		};
		Place[] placeArray = new Place[]{questDiagnostics, cvs, the24HourDoc, clearMd, totalHealth};

		for (int i = 0; i < 5; i++){
			googleMap.addMarker(new MarkerOptions().position(placeArray[i].getLatLng()).title("Testing/Vaccination Location"));
		}
//		markerObj.setPosition(nyit);
//		googleMap.addMarker(new MarkerOptions().position(markerObj.getPosition()).title("NYIT Manhattan Campus"));
		}

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		assert mapFragment != null;
		mapFragment.getMapAsync(this);

		String apiKey = "AIzaSyDNT25sWBhhNJVD32hchFpcu2ceg4TQQcU";
		if (!Places.isInitialized()){
			Places.initialize(getApplicationContext(), apiKey);
		}

		PlacesClient placesClient = Places.createClient(this);
		// Initialize the AutocompleteSupportFragment.
		AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
				getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

		// Specify the types of place data to return.
		assert autocompleteFragment != null;
		autocompleteFragment.setLocationBias(RectangularBounds.newInstance(
				new LatLng(40.76977, -73.98229),
				new LatLng(40.76977, -73.98229)
		));

		autocompleteFragment.setCountries("US");

		autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG));

		// Set up a PlaceSelectionListener to handle the response.
		autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
			@Override
			public void onPlaceSelected(@NotNull Place place) {
			// TODO: Get info about the selected place.
			Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
//			googleMap.addMarker(new MarkerOptions().position(Objects.requireNonNull(place.getLatLng())).title("Testing/Vaccine Location"));
			}


			@Override
			public void onError(@NotNull Status status) {
			// TODO: Handle the error.
			Log.i(TAG, "An error occurred: " + status);
			}
		});

		}

	// Prompt the user for permission.
//	getLocationPermission();

	// Turn on the My Location layer and the related control on the map.
//	updateLocationUI();

	// Get the current location of the device and set the position of the map.
//	getDeviceLocation();
}

	/**
	 * Gets the current location of the device, and positions the map's camera.
	 */
//	private void getDeviceLocation() {
	/*
	 * Get the best and most recent location of the device, which may be null in rare
	 * cases when a location is not available.
	 */
//	try {
//		if (locationPermissionGranted) {
//			Task<Location> locationResult = fusedLocationProviderClient.getLastLocation();
//			locationResult.addOnCompleteListener(this, new OnCompleteListener<Location>() {
//				@Override
//				public void onComplete(@NonNull Task<Location> task) {
//				if (task.isSuccessful()) {
//					// Set the map's camera position to the current location of the device.
//					lastKnownLocation = task.getResult();
//					if (lastKnownLocation != null) {
//						map.moveCamera(CameraUpdateFactory.newLatLngZoom(
//								new LatLng(lastKnownLocation.getLatitude(),
//										lastKnownLocation.getLongitude()), DEFAULT_ZOOM));
//					}
//				} else {
//					Log.d(TAG, "Current location is null. Using defaults.");
//					Log.e(TAG, "Exception: %s", task.getException());
//					map.moveCamera(CameraUpdateFactory
//							.newLatLngZoom(defaultLocation, DEFAULT_ZOOM));
//					map.getUiSettings().setMyLocationButtonEnabled(false);
//				}
//				}
//			});
//		}
//	} catch (SecurityException e)  {
//		Log.e("Exception: %s", e.getMessage(), e);
//	}
//	}
//
//	/**
//	 * Prompts the user for permission to use the device location.
//	 */
//	private void getLocationPermission() {
//	/*
//	 * Request location permission, so that we can get the location of the
//	 * device. The result of the permission request is handled by a callback,
//	 * onRequestPermissionsResult.
//	 */
//	if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
//			android.Manifest.permission.ACCESS_FINE_LOCATION)
//			== PackageManager.PERMISSION_GRANTED) {
//		locationPermissionGranted = true;
//	} else {
//		ActivityCompat.requestPermissions(this,
//				new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
//				PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
//	}
//	}
//
//	/**
//	 * Handles the result of the request for location permissions.
//	 */
//	@Override
//	public void onRequestPermissionsResult(int requestCode,
//	                                       @NonNull String[] permissions,
//	                                       @NonNull int[] grantResults) {
//	locationPermissionGranted = false;
//	switch (requestCode) {
//		case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
//			// If request is cancelled, the result arrays are empty.
//			if (grantResults.length > 0
//					&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//				locationPermissionGranted = true;
//			}
//		}
//	}
//	updateLocationUI();
//	}
//
//	/**
//	 * Prompts the user to select the current place from a list of likely places, and shows the
//	 * current place on the map - provided the user has granted location permission.
//	 */
//	private void showCurrentPlace() {
//	if (map == null) {
//		return;
//	}
//
//	if (locationPermissionGranted) {
//		// Use fields to define the data types to return.
//		List<Place.Field> placeFields = Arrays.asList(Place.Field.NAME, Place.Field.ADDRESS,
//				Place.Field.LAT_LNG);
//
//		// Use the builder to create a FindCurrentPlaceRequest.
//		FindCurrentPlaceRequest request =
//				FindCurrentPlaceRequest.newInstance(placeFields);
//
//		// Get the likely places - that is, the businesses and other points of interest that
//		// are the best match for the device's current location.
//		@SuppressWarnings("MissingPermission") final
//		Task<FindCurrentPlaceResponse> placeResult =
//				placesClient.findCurrentPlace(request);
//		placeResult.addOnCompleteListener (new OnCompleteListener<FindCurrentPlaceResponse>() {
//			@Override
//			public void onComplete(@NonNull Task<FindCurrentPlaceResponse> task) {
//			if (task.isSuccessful() && task.getResult() != null) {
//				FindCurrentPlaceResponse likelyPlaces = task.getResult();
//
//				// Set the count, handling cases where less than 5 entries are returned.
//				int count;
//				if (likelyPlaces.getPlaceLikelihoods().size() < M_MAX_ENTRIES) {
//					count = likelyPlaces.getPlaceLikelihoods().size();
//				} else {
//					count = M_MAX_ENTRIES;
//				}
//
//				int i = 0;
//				likelyPlaceNames = new String[count];
//				likelyPlaceAddresses = new String[count];
//				likelyPlaceAttributions = new List[count];
//				likelyPlaceLatLngs = new LatLng[count];
//
//				for (PlaceLikelihood placeLikelihood : likelyPlaces.getPlaceLikelihoods()) {
//					// Build a list of likely places to show the user.
//					likelyPlaceNames[i] = placeLikelihood.getPlace().getName();
//					likelyPlaceAddresses[i] = placeLikelihood.getPlace().getAddress();
//					likelyPlaceAttributions[i] = placeLikelihood.getPlace()
//							.getAttributions();
//					likelyPlaceLatLngs[i] = placeLikelihood.getPlace().getLatLng();
//
//					i++;
//					if (i > (count - 1)) {
//						break;
//					}
//				}
//
//				// Show a dialog offering the user the list of likely places, and add a
//				// marker at the selected place.
//				MapsActivityCurrentPlace.this.openPlacesDialog();
//			}
//			else {
//				Log.e(TAG, "Exception: %s", task.getException());
//			}
//			}
//		});
//	} else {
//		// The user has not granted permission.
//		Log.i(TAG, "The user did not grant location permission.");
//
//		// Add a default marker, because the user hasn't selected a place.
//		map.addMarker(new MarkerOptions()
//				.title(getString(R.string.default_info_title))
//				.position(defaultLocation)
//				.snippet(getString(R.string.default_info_snippet)));
//
//		// Prompt the user for permission.
//		getLocationPermission();
//	}
//	}
//
//	/**
//	 * Displays a form allowing the user to select a place from a list of likely places.
//	 */
//	private void openPlacesDialog() {
//	// Ask the user to choose the place where they are now.
//	DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
//		@Override
//		public void onClick(DialogInterface dialog, int which) {
//		// The "which" argument contains the position of the selected item.
//		LatLng markerLatLng = likelyPlaceLatLngs[which];
//		String markerSnippet = likelyPlaceAddresses[which];
//		if (likelyPlaceAttributions[which] != null) {
//			markerSnippet = markerSnippet + "\n" + likelyPlaceAttributions[which];
//		}
//
//		// Add a marker for the selected place, with an info window
//		// showing information about that place.
//		map.addMarker(new MarkerOptions()
//				.title(likelyPlaceNames[which])
//				.position(markerLatLng)
//				.snippet(markerSnippet));
//
//		// Position the map's camera at the location of the marker.
//		map.moveCamera(CameraUpdateFactory.newLatLngZoom(markerLatLng,
//				DEFAULT_ZOOM));
//		}
//	};
//
//	// Display the dialog.
//	AlertDialog dialog = new AlertDialog.Builder(this)
//			.setTitle(R.string.pick_place)
//			.setItems(likelyPlaceNames, listener)
//			.show();
//	}
//
//	/**
//	 * Updates the map's UI settings based on whether the user has granted location permission.
//	 */
//	private void updateLocationUI() {
//	if (map == null) {
//		return;
//	}
//	try {
//		if (locationPermissionGranted) {
//			map.setMyLocationEnabled(true);
//			map.getUiSettings().setMyLocationButtonEnabled(true);
//		} else {
//			map.setMyLocationEnabled(false);
//			map.getUiSettings().setMyLocationButtonEnabled(false);
//			lastKnownLocation = null;
//			getLocationPermission();
//		}
//	} catch (SecurityException e)  {
//		Log.e("Exception: %s", e.getMessage());
//	}
//	}