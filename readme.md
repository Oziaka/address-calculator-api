Welcome this REST API has an will help students who can not calculate network addresses such as broadcast address, network address, how to divide the network into a subnet and perform determine if the addresses belong to the same network. 

The type of address ( addressType, maskType) is a "DECIMAL", "BINARY", "NUMBER_OF_ONES" (only for mask)

This api can solve four types of tasks:
####  Divide network to subnet:
> Request: .../divideNetwork?divideNetworkWithSubnet=2

Request param divideNetworkWithSubnet is between 1 and 65536

```
 {
    "address": "191.168.0.1",
    "addressType": "DECIMAL",
    "mask": "255.0.0.0",
    "maskType": "DECIMAL"
  }
```
> Response 200 Status Ok
```
{
    "networkMask": {
        "numberOfOnesNetworkMask": {
            "address": 9
        },
        "binaryNetworkMask": {
            "address": "11111111.10000000.00000000.00000000"
        },
        "decimalNetworkMask": {
            "address": "255.128.0.0"
        }
    },
    "subnetAddresses": [
        {
            "address": {
                "binaryAddress": {
                    "address": "10111111.00000000.00000000.00000000"
                },
                "decimalAddress": {
                    "address": "191.0.0.0"
                }
            },
            "broadcastAddress": {
                "binaryAddress": {
                    "address": "10111111.01111111.11111111.11111111"
                },
                "decimalAddress": {
                    "address": "191.127.255.255"
                }
            },
            "firstHostAddress": {
                "binaryAddress": {
                    "address": "10111111.00000000.00000000.0000001"
                },
                "decimalAddress": {
                    "address": "191.0.0.1"
                }
            },
            "lastHostAddress": {
                "binaryAddress": {
                    "address": "10111111.01111111.11111111.1111110"
                },
                "decimalAddress": {
                    "address": "191.127.255.126"
                }
            }
        },
        {
            "address": {
                "binaryAddress": {
                    "address": "10111111.10000000.00000000.00000000"
                },
                "decimalAddress": {
                    "address": "191.128.0.0"
                }
            },
            "broadcastAddress": {
                "binaryAddress": {
                    "address": "10111111.11111111.11111111.11111111"
                },
                "decimalAddress": {
                    "address": "191.255.255.255"
                }
            },
            "firstHostAddress": {
                "binaryAddress": {
                    "address": "10111111.10000000.00000000.0000001"
                },
                "decimalAddress": {
                    "address": "191.128.0.1"
                }
            },
            "lastHostAddress": {
                "binaryAddress": {
                    "address": "10111111.11111111.11111111.1111110"
                },
                "decimalAddress": {
                    "address": "191.255.255.126"
                }
            }
        }
    ],
    "numberOfSubnet": 2,
    "numberOfHosts": 8388608
}
```
####  Divide network to subnet:

> Request: .../divideNetwork?divideNetwork=2

Request param divideNetworkWithSubnet is between 1 and 1073741823

```
 {
    "address": "191.168.0.1",
    "addressType": "DECIMAL",
    "mask": "255.0.0.0",
    "maskType": "DECIMAL"
  }
```
> Response 200 Status Ok
```
{
    "networkMask": {
        "numberOfOnesNetworkMask": {
            "address": 9
        },
        "binaryNetworkMask": {
            "address": "11111111.10000000.00000000.00000000"
        },
        "decimalNetworkMask": {
            "address": "255.128.0.0"
        }
    },
    "subnetAddresses": null,
    "numberOfSubnet": 2,
    "numberOfHosts": 8388608
}
```
###  Calculate broadcast and network address:

> Request: .../calculateBroadcastAndNetworkAddress
```
{
    "address": "191.168.0.1",
    "addressType": "DECIMAL",
    "mask": "255.255.0.0",
    "maskType": "DECIMAL"
}
```
> Response 200 Status Ok
```
{
    "address": {
        "binaryAddress": {
            "address": "10111111.10101000.0.0"
        },
        "decimalAddress": {
            "address": "191.168.0.0"
        }
    },
    "broadcastAddress": {
        "binaryAddress": {
            "address": "10111111.10101000.11111111.11111111"
        },
        "decimalAddress": {
            "address": "191.168.255.255"
        }
    }
}
```
###  Calculate broadcast and network address:

This uri help when you to get to know could addresses are on the same network

> Request: .../calculateBroadcastAndNetworkAddress
```
[
  {
    "address": "191.168.0.1",
    "addressType": "DECIMAL",
    "mask": "255.255.0.0",
    "maskType": "DECIMAL"
  },
  {
    "address": "191.168.0.2",
    "addressType": "DECIMAL",
    "mask": "255.255.0.0",
    "maskType": "DECIMAL"
  }
]
```
> Response 200 Status Ok
```
[
    {
        "network": {
            "networkAddress": {
                "binaryAddress": {
                    "address": "10111111.10101000.0.0"
                },
                "decimalAddress": {
                    "address": "191.168.0.0"
                }
            },
            "networkMask": {
                "numberOfOnesNetworkMask": {
                    "address": 16
                },
                "binaryNetworkMask": {
                    "address": "11111111.11111111.0.0"
                },
                "decimalNetworkMask": {
                    "address": "255.255.0.0"
                }
            },
            "broadcastAddress": {
                "binaryAddress": {
                    "address": "10111111.10101000.11111111.11111111"
                },
                "decimalAddress": {
                    "address": "191.168.255.255"
                }
            },
            "firstHostAddress": {
                "binaryAddress": {
                    "address": "10111111.10101000.01"
                },
                "decimalAddress": {
                    "address": "191.168.1"
                }
            },
            "lastHostAddress": {
                "binaryAddress": {
                    "address": "10111111.10101000.11111111.1111110"
                },
                "decimalAddress": {
                    "address": "191.168.255.126"
                }
            }
        },
        "hosts": [
            {
                "binaryAddress": {
                    "address": "10111111.10101000.0.1"
                },
                "decimalAddress": {
                    "address": "191.168.0.1"
                }
            },
            {
                "binaryAddress": {
                    "address": "10111111.10101000.0.10"
                },
                "decimalAddress": {
                    "address": "191.168.0.2"
                }
            }
        ]
    }
]
```



